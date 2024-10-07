<%-- 
    Document   : Auth
    Created on : 27 may 2024, 11:24:38 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<main>

    <div class="contenedor__todo">
        <div class="caja__trasera">
            <div class="caja__trasera-login">
                <h3>¿Ya tienes una cuenta?</h3>
                <p>Inicia sesión para entrar en la página</p>
                <button id="btn__iniciar-sesion">Iniciar Sesión</button>
            </div>
            <div class="caja__trasera-register">
                <h3>¿Aún no tienes una cuenta?</h3>
                <p>Regístrate para que puedas iniciar sesión</p>
                <button id="btn__registrarse">Regístrarse</button>
            </div>
        </div>

        <!--Formulario de Login y registro-->
        <div class="contenedor__login-register">
            <!--Login-->
            <form action="<%= request.getContextPath()%>/login" method="POST" class="formulario__login">
                <h2>Iniciar Sesión Al Colegio</h2>

                <input type="hidden" name="action" value="loginService">

                <input type="text" name="username" placeholder="Correo Electronico">
                <input type="password" name="password" placeholder="Contraseña">

                <button>Entrar</button>
            </form>

            <!--Register-->
            <form action="<%= request.getContextPath()%>/login" method="POST" class="formulario__register" onsubmit="return validateForm()">
                <input type="hidden" name="action" value="registerUserLogin">
                <h2>Regístrarse</h2>
                <input type="text" id="name" name="name" placeholder="Nombre completo">
                <input type="text" id="email" name="email" placeholder="Correo Electronico">
                <input type="text" id="user" name="user" placeholder="Usuario">
                <input type="password" id="password" name="password" placeholder="Contraseña">
                <button type="submit">Regístrarse</button>
            </form>

            <script>
                function validateForm() {
                    var name = document.getElementById('name').value;
                    var email = document.getElementById('email').value;
                    var user = document.getElementById('user').value;
                    var password = document.getElementById('password').value;

                    if (!name || !email || !user || !password) {
                        alert("Todos los campos son obligatorios");
                        return false;
                    }

                    // Validación de correo electrónico
                    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
                    if (!emailPattern.test(email)) {
                        alert("Por favor ingrese un correo electrónico válido");
                        return false;
                    }

                    return true;
                }
            </script>
        </div>
    </div>
    <script src="views/auth/js/jsAuth.js" type="text/javascript"></script>
</main>

