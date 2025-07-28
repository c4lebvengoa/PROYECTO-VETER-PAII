// Configuración de la API
const API_BASE_URL = '/api'; // La URL base de la API de Spring Boot

// Utilidad para mostrar/ocultar elementos de loading y error
function mostrarLoading(seccion, mostrar = true) {
    const loading = document.getElementById(`loading${seccion}`);
    if (loading) {
        loading.style.display = mostrar ? 'block' : 'none';
    }
}

function mostrarError(seccion, mensaje = '') {
    const error = document.getElementById(`error${seccion}`);
    if (error) {
        error.textContent = mensaje;
        error.style.display = mensaje ? 'block' : 'none';
    }
}

// Función genérica para hacer peticiones HTTP
async function fetchData(url, method = 'GET', data = null) {
    const options = {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        }
    };

    if (data) {
        options.body = JSON.stringify(data);
    }

    try {
        const response = await fetch(`${API_BASE_URL}${url}`, options);
        
        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error ${response.status}: ${errorText}`);
        }
        
        return await response.json();
    } catch (error) {
        console.error('Error en fetchData:', error);
        throw error;
    }
}

// Funciones para manejar pestañas
function mostrarTab(tabId) {
    // Ocultar todas las pestañas
    document.querySelectorAll('.tab-content').forEach(tab => {
        tab.classList.remove('active');
    });
    
    // Mostrar la pestaña seleccionada
    const selectedTab = document.getElementById(tabId);
    if (selectedTab) {
        selectedTab.classList.add('active');
    }
    
    // Actualizar navegación
    document.querySelectorAll('.nav-link').forEach(link => {
        link.classList.remove('active');
    });
    document.querySelector(`[data-tab="${tabId}"]`).classList.add('active');
    
    // Cargar datos de la pestaña correspondiente
    switch(tabId) {
        case 'dashboard':
            actualizarDashboard();
            break;
        case 'usuarios':
            cargarUsuarios();
            break;
        case 'libros':
            cargarLibros();
            cargarCategoriasSelect();
            break;
        case 'autores':
            cargarAutores();
            break;
        case 'categorias':
            cargarCategorias();
            break;
    }
}

// Funciones del Dashboard
async function actualizarDashboard() {
    try {
        const estadisticas = await fetchData('/dashboard/estadisticas');
        
        document.getElementById('totalUsuarios').textContent = estadisticas.totalUsuarios;
        document.getElementById('totalLibros').textContent = estadisticas.totalLibros;
        document.getElementById('totalPrestamos').textContent = estadisticas.totalPrestamos;
        document.getElementById('totalVencidos').textContent = estadisticas.totalVencidos;
    } catch (error) {
        console.error('Error al actualizar dashboard:', error);
    }
}

// Funciones para manejar usuarios
async function cargarUsuarios() {
    mostrarLoading('Usuarios', true);
    mostrarError('Usuarios', '');
    
    try {
        const usuarios = await fetchData('/usuarios');
        const tbody = document.getElementById('tablaUsuarios');
        tbody.innerHTML = '';

        usuarios.forEach(usuario => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${usuario.idUsu}</td>
                <td>${usuario.nombreUsu}</td>
                <td>${usuario.apellPat}</td>
                <td>${usuario.apellMat}</td>
                <td>${usuario.codUsu}</td>
                <td>${usuario.telf}</td>
                <td>
                    <button class="btn btn-sm btn-primary me-1" onclick="editarUsuario(${usuario.idUsu})">
                        <i class="bi bi-pencil"></i>
                    </button>
                    <button class="btn btn-sm btn-danger" onclick="eliminarUsuario(${usuario.idUsu})">
                        <i class="bi bi-trash"></i>
                    </button>
                </td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        mostrarError('Usuarios', `Error al cargar usuarios: ${error.message}`);
    } finally {
        mostrarLoading('Usuarios', false);
    }
}

function abrirModalUsuario() {
    const modal = new bootstrap.Modal(document.getElementById('modalUsuario'));
    const form = document.getElementById('formUsuario');
    form.reset();
    form.dataset.method = 'POST';
    form.dataset.id = '';
    modal.show();
}

async function guardarUsuario() {
    const form = document.getElementById('formUsuario');
    const method = form.dataset.method || 'POST';
    const id = form.dataset.id || '';

    try {
        const data = {
            nombreUsu: form.nombreUsu.value,
            apellPat: form.apellPat.value,
            apellMat: form.apellMat.value,
            codUsu: form.codUsu.value,
            telf: form.telf.value,
            contrasena: form.contrasena.value
        };

        await fetchData(`/usuarios${id ? '/' + id : ''}`, method, data);
        
        const modal = bootstrap.Modal.getInstance(document.getElementById('modalUsuario'));
        modal.hide();
        
        await cargarUsuarios();
        alert('Usuario guardado exitosamente');
    } catch (error) {
        alert(`Error al guardar usuario: ${error.message}`);
    }
}

async function editarUsuario(id) {
    try {
        const usuario = await fetchData(`/usuarios/${id}`);
        const form = document.getElementById('formUsuario');
        
        form.dataset.method = 'PUT';
        form.dataset.id = id;
        form.nombreUsu.value = usuario.nombreUsu;
        form.apellPat.value = usuario.apellPat;
        form.apellMat.value = usuario.apellMat;
        form.codUsu.value = usuario.codUsu;
        form.telf.value = usuario.telf;
        form.contrasena.value = '';

        const modal = new bootstrap.Modal(document.getElementById('modalUsuario'));
        modal.show();
    } catch (error) {
        alert(`Error al cargar usuario: ${error.message}`);
    }
}

async function eliminarUsuario(id) {
    if (confirm('¿Está seguro de eliminar este usuario?')) {
        try {
            await fetchData(`/usuarios/${id}`, 'DELETE');
            await cargarUsuarios();
            alert('Usuario eliminado exitosamente');
        } catch (error) {
            alert(`Error al eliminar usuario: ${error.message}`);
        }
    }
}

// Funciones para manejar libros
async function cargarLibros() {
    mostrarLoading('Libros', true);
    mostrarError('Libros', '');
    
    try {
        const libros = await fetchData('/libros');
        mostrarLibrosEnTabla(libros);
    } catch (error) {
        mostrarError('Libros', `Error al cargar libros: ${error.message}`);
    } finally {
        mostrarLoading('Libros', false);
    }
}

async function buscarLibros() {
    mostrarLoading('Libros', true);
    mostrarError('Libros', '');
    
    try {
        const titulo = document.getElementById('buscarTitulo').value;
        const categoriaId = document.getElementById('filtroCategoria').value;
        const disponible = document.getElementById('filtroDisponible').value;

        const params = new URLSearchParams();
        if (titulo) params.append('titulo', titulo);
        if (categoriaId) params.append('categoriaId', categoriaId);
        if (disponible !== '') params.append('disponible', disponible);

        const libros = await fetchData(`/libros/buscar?${params.toString()}`);
        mostrarLibrosEnTabla(libros);
    } catch (error) {
        mostrarError('Libros', `Error al buscar libros: ${error.message}`);
    } finally {
        mostrarLoading('Libros', false);
    }
}

function mostrarLibrosEnTabla(libros) {
    const tbody = document.getElementById('tablaLibros');
    tbody.innerHTML = '';

    libros.forEach(libro => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${libro.idLibro}</td>
            <td>${libro.titulo}</td>
            <td>${libro.anioPubli}</td>
            <td>${libro.cantTotal}</td>
            <td>${libro.cantDisponible}</td>
            <td>${libro.categoria ? libro.categoria.nombreCat : 'Sin categoría'}</td>
            <td>${libro.autor ? libro.autor.nombre + ' ' + libro.autor.apellPat : 'Sin autor'}</td>
            <td>
                <button class="btn btn-sm btn-primary me-1" onclick="editarLibro(${libro.idLibro})">
                    <i class="bi bi-pencil"></i>
                </button>
                <button class="btn btn-sm btn-danger" onclick="eliminarLibro(${libro.idLibro})">
                    <i class="bi bi-trash"></i>
                </button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

async function abrirModalLibro() {
    const modal = new bootstrap.Modal(document.getElementById('modalLibro'));
    const form = document.getElementById('formLibro');
    form.reset();
    form.dataset.method = 'POST';
    form.dataset.id = '';
    
    await cargarAutoresSelect();
    await cargarCategoriasSelect();
    
    modal.show();
}

async function cargarAutoresSelect() {
    try {
        const autores = await fetchData('/autores');
        const selectAutor = document.querySelector('select[name="autorId"]');
        selectAutor.innerHTML = '<option value="">Seleccione un autor</option>';
        
        autores.forEach(autor => {
            const option = document.createElement('option');
            option.value = autor.idAutor;
            option.textContent = `${autor.nombre} ${autor.apellPat} ${autor.apellMat}`;
            selectAutor.appendChild(option);
        });
    } catch (error) {
        console.error('Error al cargar autores:', error);
    }
}

async function cargarCategoriasSelect() {
    try {
        const categorias = await fetchData('/categorias');
        const selectCategoria = document.querySelector('select[name="categoriaId"]');
        const filtroCategoria = document.getElementById('filtroCategoria');
        
        // Actualizar select del modal
        selectCategoria.innerHTML = '<option value="">Seleccione una categoría</option>';
        
        // Actualizar filtro de búsqueda
        filtroCategoria.innerHTML = '<option value="">Todas las categorías</option>';
        
        categorias.forEach(categoria => {
            const option1 = document.createElement('option');
            option1.value = categoria.idCategoria;
            option1.textContent = categoria.nombreCat;
            selectCategoria.appendChild(option1);
            
            const option2 = document.createElement('option');
            option2.value = categoria.idCategoria;
            option2.textContent = categoria.nombreCat;
            filtroCategoria.appendChild(option2);
        });
    } catch (error) {
        console.error('Error al cargar categorías:', error);
    }
}

async function guardarLibro() {
    const form = document.getElementById('formLibro');
    const method = form.dataset.method || 'POST';
    const id = form.dataset.id || '';

    try {
        const data = {
            titulo: form.titulo.value,
            anioPubli: form.anioPubli.value,
            cantTotal: parseInt(form.cantTotal.value),
            autorId: parseInt(form.autorId.value),
            categoriaId: parseInt(form.categoriaId.value)
        };

        await fetchData(`/libros${id ? '/' + id : ''}`, method, data);
        
        const modal = bootstrap.Modal.getInstance(document.getElementById('modalLibro'));
        modal.hide();
        
        await cargarLibros();
        alert('Libro guardado exitosamente');
    } catch (error) {
        alert(`Error al guardar libro: ${error.message}`);
    }
}

async function editarLibro(id) {
    try {
        const libro = await fetchData(`/libros/${id}`);
        const form = document.getElementById('formLibro');
        
        await cargarAutoresSelect();
        await cargarCategoriasSelect();
        
        form.dataset.method = 'PUT';
        form.dataset.id = id;
        form.titulo.value = libro.titulo;
        form.anioPubli.value = libro.anioPubli;
        form.cantTotal.value = libro.cantTotal;
        form.autorId.value = libro.autor ? libro.autor.idAutor : '';
        form.categoriaId.value = libro.categoria ? libro.categoria.idCategoria : '';

        const modal = new bootstrap.Modal(document.getElementById('modalLibro'));
        modal.show();
    } catch (error) {
        alert(`Error al cargar libro: ${error.message}`);
    }
}

async function eliminarLibro(id) {
    if (confirm('¿Está seguro de eliminar este libro?')) {
        try {
            await fetchData(`/libros/${id}`, 'DELETE');
            await cargarLibros();
            alert('Libro eliminado exitosamente');
        } catch (error) {
            alert(`Error al eliminar libro: ${error.message}`);
        }
    }
}

// Funciones para manejar autores
async function cargarAutores() {
    mostrarLoading('Autores', true);
    mostrarError('Autores', '');
    
    try {
        const autores = await fetchData('/autores');
        const tbody = document.getElementById('tablaAutores');
        tbody.innerHTML = '';

        autores.forEach(autor => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${autor.idAutor}</td>
                <td>${autor.nombre}</td>
                <td>${autor.apellPat}</td>
                <td>${autor.apellMat}</td>
                <td>
                    <button class="btn btn-sm btn-primary me-1" onclick="editarAutor(${autor.idAutor})">
                        <i class="bi bi-pencil"></i>
                    </button>
                    <button class="btn btn-sm btn-danger" onclick="eliminarAutor(${autor.idAutor})">
                        <i class="bi bi-trash"></i>
                    </button>
                </td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        mostrarError('Autores', `Error al cargar autores: ${error.message}`);
    } finally {
        mostrarLoading('Autores', false);
    }
}

function abrirModalAutor() {
    const modal = new bootstrap.Modal(document.getElementById('modalAutor'));
    const form = document.getElementById('formAutor');
    form.reset();
    form.dataset.method = 'POST';
    form.dataset.id = '';
    modal.show();
}

async function guardarAutor() {
    const form = document.getElementById('formAutor');
    const method = form.dataset.method || 'POST';
    const id = form.dataset.id || '';

    try {
        const data = {
            nombre: form.nombre.value,
            apellPat: form.apellPat.value,
            apellMat: form.apellMat.value
        };

        await fetchData(`/autores${id ? '/' + id : ''}`, method, data);
        
        const modal = bootstrap.Modal.getInstance(document.getElementById('modalAutor'));
        modal.hide();
        
        await cargarAutores();
        alert('Autor guardado exitosamente');
    } catch (error) {
        alert(`Error al guardar autor: ${error.message}`);
    }
}

async function editarAutor(id) {
    try {
        const autor = await fetchData(`/autores/${id}`);
        const form = document.getElementById('formAutor');
        
        form.dataset.method = 'PUT';
        form.dataset.id = id;
        form.nombre.value = autor.nombre;
        form.apellPat.value = autor.apellPat;
        form.apellMat.value = autor.apellMat;

        const modal = new bootstrap.Modal(document.getElementById('modalAutor'));
        modal.show();
    } catch (error) {
        alert(`Error al cargar autor: ${error.message}`);
    }
}

async function eliminarAutor(id) {
    if (confirm('¿Está seguro de eliminar este autor?')) {
        try {
            await fetchData(`/autores/${id}`, 'DELETE');
            await cargarAutores();
            alert('Autor eliminado exitosamente');
        } catch (error) {
            alert(`Error al eliminar autor: ${error.message}`);
        }
    }
}

// Funciones para manejar categorías
async function cargarCategorias() {
    mostrarLoading('Categorias', true);
    mostrarError('Categorias', '');
    
    try {
        const categorias = await fetchData('/categorias');
        const tbody = document.getElementById('tablaCategorias');
        tbody.innerHTML = '';

        categorias.forEach(categoria => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${categoria.idCategoria}</td>
                <td>${categoria.nombreCat}</td>
                <td>${categoria.descripcion || ''}</td>
                <td>
                    <button class="btn btn-sm btn-primary me-1" onclick="editarCategoria(${categoria.idCategoria})">
                        <i class="bi bi-pencil"></i>
                    </button>
                    <button class="btn btn-sm btn-danger" onclick="eliminarCategoria(${categoria.idCategoria})">
                        <i class="bi bi-trash"></i>
                    </button>
                </td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        mostrarError('Categorias', `Error al cargar categorías: ${error.message}`);
    } finally {
        mostrarLoading('Categorias', false);
    }
}

function abrirModalCategoria() {
    const modal = new bootstrap.Modal(document.getElementById('modalCategoria'));
    const form = document.getElementById('formCategoria');
    form.reset();
    form.dataset.method = 'POST';
    form.dataset.id = '';
    modal.show();
}

async function guardarCategoria() {
    const form = document.getElementById('formCategoria');
    const method = form.dataset.method || 'POST';
    const id = form.dataset.id || '';

    try {
        const data = {
            nombreCat: form.nombreCat.value,
            descripcion: form.descripcion.value
        };

        await fetchData(`/categorias${id ? '/' + id : ''}`, method, data);
        
        const modal = bootstrap.Modal.getInstance(document.getElementById('modalCategoria'));
        modal.hide();
        
        await cargarCategorias();
        alert('Categoría guardada exitosamente');
    } catch (error) {
        alert(`Error al guardar categoría: ${error.message}`);
    }
}

async function editarCategoria(id) {
    try {
        const categoria = await fetchData(`/categorias/${id}`);
        const form = document.getElementById('formCategoria');
        
        form.dataset.method = 'PUT';
        form.dataset.id = id;
        form.nombreCat.value = categoria.nombreCat;
        form.descripcion.value = categoria.descripcion || '';

        const modal = new bootstrap.Modal(document.getElementById('modalCategoria'));
        modal.show();
    } catch (error) {
        alert(`Error al cargar categoría: ${error.message}`);
    }
}

async function eliminarCategoria(id) {
    if (confirm('¿Está seguro de eliminar esta categoría?')) {
        try {
            await fetchData(`/categorias/${id}`, 'DELETE');
            await cargarCategorias();
            alert('Categoría eliminada exitosamente');
        } catch (error) {
            alert(`Error al eliminar categoría: ${error.message}`);
        }
    }
}

// Event listeners para navegación y formularios
document.addEventListener('DOMContentLoaded', function() {
    // Manejar clics en navegación
    document.querySelectorAll('[data-tab]').forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const tabId = this.getAttribute('data-tab');
            mostrarTab(tabId);
        });
    });
    
    // Manejar envío de formularios
    document.getElementById('formUsuario').addEventListener('submit', function(e) {
        e.preventDefault();
        guardarUsuario();
    });
    
    document.getElementById('formLibro').addEventListener('submit', function(e) {
        e.preventDefault();
        guardarLibro();
    });
    
    document.getElementById('formAutor').addEventListener('submit', function(e) {
        e.preventDefault();
        guardarAutor();
    });
    
    document.getElementById('formCategoria').addEventListener('submit', function(e) {
        e.preventDefault();
        guardarCategoria();
    });
    
    // Cargar datos iniciales
    actualizarDashboard();
});