// Arreglos para almacenar ingresos y egresos
let ingresos = [];
let egresos = [];

// Función para cargar la aplicación
let cargarApp = async () => {
    try {
        let response = await fetch('admin', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        if (response.ok) {
            let data = await response.json();
            console.log(data);
            ingresos = data.ingresos;
            egresos = data.egresos;
            actualizarInterfaz();
        } else {
            console.error('Error al obtener datos del servidor.');
        }
    } catch (error) {
        console.error('Error en la solicitud AJAX:', error);
    }
};


// Función para actualizar la interfaz gráfica con los datos de ingresos y egresos
let actualizarInterfaz = () => {
    cargarCabecero();
    cargarIngresos();
    cargarEgresos();
};

// Función para calcular el total de ingresos
let totalIngresos = () => {
    return ingresos.reduce((total, ingreso) => total + parseFloat(ingreso.valor), 0);
};

// Función para calcular el total de egresos
let totalEgresos = () => {
    return egresos.reduce((total, egreso) => total + parseFloat(egreso.valor), 0);
};

// Función para cargar el cabecero con los datos de presupuesto, ingresos y egresos
let cargarCabecero = () => {
    let presupuesto = totalIngresos() - totalEgresos();
    let porcentajeEgreso = totalEgresos() / totalIngresos();
    document.getElementById('presupuesto').innerHTML = formatoMoneda(presupuesto);
    document.getElementById('porcentaje').innerHTML = formatoPorcentaje(porcentajeEgreso);
    document.getElementById('ingresos').innerHTML = formatoMoneda(totalIngresos());
    document.getElementById('egresos').innerHTML = formatoMoneda(totalEgresos());
};

// Función para dar formato a moneda
const formatoMoneda = (valor) => {
    return valor.toLocaleString('es-ES', {style: 'currency', currency: 'EUR', minimumFractionDigits: 2});
};

// Función para dar formato a porcentaje
const formatoPorcentaje = (valor) => {
    return (valor * 100).toLocaleString('en-US', {style: 'percent', minimumFractionDigits: 2});
};

// Función para cargar los ingresos en la interfaz
const cargarIngresos = () => {
    let ingresosHTML = '';
    for (let ingreso of ingresos) {
        ingresosHTML += crearPagoHTML(ingreso, 'ingreso');
    }
    document.getElementById('lista-ingresos').innerHTML = ingresosHTML;
};

// Función para cargar los egresos en la interfaz
const cargarEgresos = () => {
    let egresosHTML = '';
    for (let egreso of egresos) {
        egresosHTML += crearPagoHTML(egreso, 'egreso');
    }
    document.getElementById('lista-egresos').innerHTML = egresosHTML;
};

// Función para crear el HTML de un ingreso o egreso
const crearPagoHTML = (pago, tipo) => {
    return `
        <div class="elemento limpiarEstilos">
            <div class="elemento_descripcion">${pago.description}</div>
            <div class="derecha limpiarEstilos">
                <div class="elemento_valor">${tipo === 'ingreso' ? '+ ' : '- '}${formatoMoneda(pago.valor)}</div>
                <div class="elemento_eliminar">
                    <button type="submit" onclick="eliminarPago(${pago.idPagos}, '${tipo}')" class="btn btn-primary">E</button>
                </div>
            </div>
        </div>
    `;
};

// Función para eliminar un pago (ingreso o egreso)
const eliminarPago = async (id, tipo) => {
    if (confirm(`¿Estás seguro de eliminar este ${tipo}?`)) {
        try {
            let response = await fetch('admin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: `action=delete&idpagos=${id}`
            });

            if (response.ok) {
                if (tipo === 'ingreso') {
                    ingresos = ingresos.filter(ingreso => ingreso.idPagos !== id);
                    cargarApp();
                } else if (tipo === 'egreso') {
                    egresos = egresos.filter(egreso => egreso.idPagos !== id);
                    cargarApp();
                }
            } else {
                console.error('Error al eliminar el pago.');
            }
        } catch (error) {
            console.error('Error en la solicitud AJAX:', error);
        }
    }
};

// Función para agregar un nuevo pago
const agregarDato = async () => {
    let tipo = document.getElementById('tipo').value;
    let descripcion = document.getElementById('descripcion').value;
    let valor = document.getElementById('valor').value;

    if (descripcion === '' || valor === '') {
        alert('Por favor, complete todos los campos');
        return;
    }

    let data = {
        action: tipo === 'ingreso' ? 'createIngreso' : 'createEgreso',
        description: descripcion,
        valor: parseFloat(valor),
        idUser: 1 // Este es un valor de ejemplo, reemplázalo según sea necesario
    };

    try {
        let response = await fetch('admin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams(data)
        });

        let result = await response.json();

        if (result.success) {
            cargarApp(); // Actualizar la página después de agregar
        } else {
            alert('Error al agregar el dato');
        }
    } catch (error) {
        console.error('Error en la solicitud AJAX:', error);
    }
};

// Cargar la aplicación cuando el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', cargarApp);
