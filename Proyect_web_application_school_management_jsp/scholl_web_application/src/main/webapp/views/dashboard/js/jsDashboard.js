/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// Selecciona el elemento con la clase 'navbar'
let navbar = document.querySelector('.header .navbar');

// Maneja el clic en el botón con id 'menu-btn'
document.querySelector('#menu-btn').onclick = () => {
    // Alterna la clase 'active' en el elemento 'navbar'
    navbar.classList.toggle('active');
    // Remueve la clase 'active' del formulario de inicio de sesión
    loginForm.classList.remove('active');
}

// Selecciona el elemento con la clase 'login-form'
let loginForm = document.querySelector('.login-form');

// Maneja el clic en el botón con id 'login-btn'
document.querySelector('#login-btn').onclick = () => {
    // Alterna la clase 'active' en el formulario de inicio de sesión
    loginForm.classList.toggle('active');
    // Remueve la clase 'active' del elemento 'navbar'
    navbar.classList.remove('active');
}

// Maneja el evento de desplazamiento de la ventana
window.onscroll = () => {
    // Remueve la clase 'active' tanto del elemento 'navbar' como del formulario de inicio de sesión
    navbar.classList.remove('active');
    loginForm.classList.remove('active');
}

// Inicializa un objeto Swiper para la clase 'review-slider'
var swiper = new Swiper(".review-slider", {
    spaceBetween: 20,
    centeredSlides: true,
    grabCursor: true,
    autoplay: {
        delay: 7500,
        disableOnInteraction: false,
    },
    loop: true,
    breakpoints: {
        0: {
            slidesPerView: 1,
        },
        768: {
            slidesPerView: 2,
        },
        991: {
            slidesPerView: 3,
        },
    },
});
async function sendData() {
    const url = `ControllerStudent`;

    fetch(url)
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                alert(JSON.stringify(data, null, 2));  // Mostrar respuesta en una alerta
                document.getElementById("response").innerText = JSON.stringify(data, null, 2);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
}

