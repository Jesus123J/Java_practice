<%-- 
    Document   : Dashboard
    Created on : 28 may 2024, 12:00:01 a.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) request.getSession().getAttribute("username");
    if (user == null) {
        user = "";
    }
%>
<main>


    <!-- header section starts -->

    <header class="header">

        <a href="#" class="logo"><i class="fas fa-book"></i>Colegio</a>

        <nav class="navbar">
            <a href="#home" class="hover-underline">colegio</a>
            <a href="#about" class="hover-underline">Acerca</a>
            <a href="#courses" class="hover-underline">cursos</a>
            <a href="#teacher" class="hover-underline">profesores</a>
            <a href="#contact" class="hover-underline">contact</a>
            <a href="PreguntasFrec/index6.html" class="hover-underline">Preguntas Frecuentes</a>
            <% if (!user.isEmpty()) {%>
            <a href="<%= request.getContextPath()%>/admin" class="hover-underline">metodo y gastos de pago</a>
            <% }%>
            <a href="" class="custom-icon-link" onclick="openCart()">
                <i class="fas fa-shopping-cart"></i> 
            </a>
        </nav>

        <div class="icons">
            <div id="login-btn" class="fas fa-user"></div>
            <div id="menu-btn" class="fas fa-bars"></div>
        </div>

        <!-- login form -->

        <a><%= user%></a>
        <form action="/login" class="login-form">
            <h3>login form</h3>
            <input type="hidden" name="accion" value="loginService">
            <input type="email" placeholder="Entre con su Hotmail" class="box">
            <input type="password" placeholder="contraseña" class="box">
            <div class="remember">
                <input type="checkbox" name="" id="remember">
                <label for="remember-me">recordar contraseña</label>
            </div>
            <a href="#" class="btn">
                <span class="text text-1">login</span>
                <span class="text text-2" aria-hidden="true">iniciar </span>
            </a>

            <span class="text text-1">crear</span>
            <button type="submit" class="btn btn-primary">Crear cuenta</button>
        </form>

    </header>
    <!-- home section starts-->

    <section class="home" id="home">

        <div class="content">
            <button type="submit"onclick="window.location.href = '<%= request.getContextPath()%>/login'" class="btn btn-primary">Crear cuenta</button>
            <h3 style="color: black;">Colegio nacional</h3>
            <p style="color: black;"> EXCELENCIA ACADÉMICA Y FORMACIÓN CRISTIANA PARA LA VIDA <br>El Colegio San Martin de  Porres es una obra del 
                Convento del Santísimo Rosario de Lima la cual pertenece a la Provincia de San Juan Bautista del Perú, 
                esta provincia fue fundada en el Perú por los frailes dominicos.

            </p>
            <a href="#" class="btn">
                <span class="text text-1">Propuesta</span>
                <span class="text text-2" aria-hidden="true"> EDUCATIVA</span>
            </a>    
        </div>

    </section>

    <!-- finalizacion delinicio desecion  -->

    <!-- sobre elinicio de decion  -->

    <section class="about" id="about">

        <h1 class="heading">Acerca Del Colegio</h1>

        <div class="container">

            <figure class="about-image">
                <img src="views/dashboard/resources/about.png" alt="" height="500">   
            </figure>

            <div class="about-content">
                <h3>23 de años de experencia</h3>
                <p>
                    es una institución educativa con una rica historia y un compromiso sólido con la excelencia académica y el desarrollo integral de nuestros estudiantes. Fundado en 1888 , hemos sido un faro de educación de calidad durante más de 50 años.
                </p>
                <p>Nuestra misión es proporcionar una educación de clase mundial que inspire a nuestros estudiantes a alcanzar su máximo potencial académico, personal y social. Estamos dedicados a fomentar un ambiente de aprendizaje inclusivo, seguro y estimulante donde cada estudiante pueda crecer y prosperar.</p>    
                <a href="#" class="btn">
                    <span class="text text-1">SABER MAS </span>
                    <span class="text text-2" aria-hidden="true">ACERCA DEL COLEGIO</span>
                </a>        
            </div>

        </div>

    </section>

    <!-- sobre los extremos de las secciones -->

    <!--   comienza la secion de materias  -->

    <section class="subjects" id="courses">

        <h1 class="heading">Cursos que veras en el colegio</h1>

        <div class="box-container">

            <div class="box">
                <img src="views/dashboard/resources/subject-1.jpg" alt="">
                <h3>Matematicas</h3>
                <p>matematicas de todos los niveles</p>
            </div>

            <div class="box">
                <img src="views/dashboard/resources/subject-2.jpg" alt="">
                <h3>ciencias</h3>
                <p>Fisica y Quimica</p>
            </div>

            <div class="box">
                <img src="views/dashboard/resources/subject-2.jpg" alt="">
                <h3>ciencias</h3>
                <p>Fisica y Quimica</p>
            </div>

            <div class="box">
                <img src="views/dashboard/resources/subject-2.jpg" alt="">
                <h3>ciencias</h3>
                <p>Fisica y Quimica</p>
            </div>

            <div class="box">
                <img src="views/dashboard/resources/subject-2.jpg" alt="">
                <h3>ciencias</h3>
                <p>Fisica y Quimica</p>
            </div>

            <div class="box">
                <img src="views/dashboard/resources/subject-2.jpg" alt="">
                <h3>ciencias</h3>
                <p>Fisica y Quimica</p>
            </div>


            <div class="box">
                <img src="views/dashboard/resources/subject-3.jpg" alt="">
                <h3>dibujo y arte</h3>
                <p>lo mejor de los dibujos que veras</p>
            </div>

            <div class="box">
                <img src="views/dashboard/resources/subject-4.jpg" alt="">
                <h3>programacion</h3>
                <p>html y css</p>
            </div>

        </div>

    </section>

    <!-- la secion tematica temrina  -->

    <!--ajafsjasfnklaf 146 302-->

    <!--comienza la secion de profesores -->

    <section class="teacher" id="teacher">

        <h1 class="heading">Profesores A1</h1>

        <div class="box-container">

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-1.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan diaz</h3>
                    <span>estudiante</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-2.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan diaz</h3>
                    <span>estudiante</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-3.jpeg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan diaz</h3>
                    <span>estudiate</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-4.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan daiz</h3>
                    <span>estudiante</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-4.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan daiz</h3>
                    <span>estudiante</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-4.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan daiz</h3>
                    <span>estudiante</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-4.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan daiz</h3>
                    <span>estudiante</span>
                </div>
            </div>

            <div class="box">
                <div class="image">
                    <img src="views/dashboard/resources/teacher-4.jpg" alt="">
                    <div class="share">
                        <a href="#" class="fab fa-facebook-f"></a>
                        <a href="#" class="fab fa-twitter"></a>
                        <a href="#" class="fab fa-instagram"></a>
                    </div>
                </div>
                <div class="content">
                    <h3>bryan daiz</h3>
                    <span>estudiante</span>
                </div>
            </div>

        </div>

    </section>

    <!-- termina la secion de profesores -->

    <!-- footer section misionnn  stars --> 

    <section class="about" id="about">

        <h1 class="heading">Mision y vison</h1>

        <div class="container">

            <figure class="about-image">
                <img src="views/dashboard/resources/about.png" alt="" height="500">   
            </figure>

            <div class="about-content">
                <h3>23 de años de experencia</h3>
                <br>
                <h3>Mision</h3>
                <p>
                    "La misión del Colegio San Martín de Porres es brindar una educación integral de alta calidad que promueva el desarrollo académico, moral, ético y social de nuestros estudiantes. Nos esforzamos por fomentar los valores de solidaridad, respeto, justicia y compromiso con la comunidad, inspirados en el ejemplo de San Martín de Porres."            
                </p>
                <br>
                <h3>vision</h3>
                <p>"La visión del Colegio San Martín de Porres es ser una institución educativa líder y reconocida a nivel nacional e internacional por su excelencia académica, valores humanos y compromiso con la formación integral de sus estudiantes. Nos esforzamos por ser un referente en la educación, promoviendo la inclusión, la innovación pedagógica y la colaboración constante con la comunidad."</p>    
                <a href="#" class="btn">
                    <span class="text text-1">SABER MAS </span>
                    <span class="text text-2" aria-hidden="true">ACERCA DEL COLEGIO</span>
                </a>        
            </div>

        </div>

    </section>


    <!-- teacher misiion  ends -->




    <section class="footer" id="contact">

        <div class="box-container">

            <div class="box">
                <h3>estamos ubicados </h3>
                <p>Avenida panamerina</p>
                <div class="share">
                    <a href="https://www.cepsmp.edu.pe/p%C3%A1gina-principal" target="_blank" class="fab fa-facebook-f"></a>
                    <a href="https://www.cepsmp.edu.pe/p%C3%A1gina-principal" class="fab fa-twitter"></a>
                    <a href="https://www.cepsmp.edu.pe/p%C3%A1gina-principal" class="fab fa-instagram"></a>
                    <a href="https://www.cepsmp.edu.pe/p%C3%A1gina-principal" class="fab fa-linkedin"></a>
                </div>
            </div>

            <div class="box">
                <h3>contacto</h3>
                <p>98754224423</p>
                <a href="https://outlook.live.com/mail/?auth=1&JitExp=1&url=%2Fowa%2F%3Fauth%253d1" class="link">bryandiaz@gmail.com</a>
            </div>

            <div class="box">
                <h3>direccion</h3>
                <p>UTP <br>
                    <a href="https://www.bing.com/maps?mepi=24%7E%7ETopOfPage%7EMap_Image&ty=18&q=Olivos%2C+Vicente+L%C3%B3pez%2C+Provincia+de+Buenos+Aires%2C+Argentina&satid=id.sid%3Aae517cc4-42f3-c6cc-4b12-4a8f50fe8a28&mb=-34.497776%7E-58.525608%7E-34.528526%7E-58.470634&ppois=-34.51315116882324_-58.49812126159668_Olivos%2C+Vicente+L%C3%B3pez%2C+Provincia+de+Buenos+Aires%2C+Argentina_%7E&cp=-34.513346%7E-58.338776&v=2&sV=1&FORM=SNAPST&lvl=11.0">olivos</a><br>
                    panamericana</p>
            </div>

        </div>
        <div class="credit">San Martin<span> DE PORRES</span> <br>2023 incripciones abiertas </div>
    </section>


    <div class="my-container">
        <div class="my-card">
            <div class="my-card-header">
                <h1 class="my-card-title">
                    Formulario de contacto
                </h1>
            </div>
            <div class="my-card-body">
                <form action="ControllerLogin" class="my-form" method="post">
                    <input type="hidden" name="accion" value="loginService">
                    <input type="text" name="nombre" placeholder="Nombre completo" class="my-input my-input-50">
                    <input type="text" placeholder="Nombre del Apoderado" class="my-input my-input-50">
                    <input type="email" name="correo" placeholder="Correo electrónico" class="my-input my-input-50">

                    <input type="text" placeholder="DNI" class="my-input my-input-50">
                    <input type="text" name="asunto" placeholder="Asunto" class="my-input">

                    <select name="pais" class="my-input my-input-50">
                        <option value="usa">Estados Unidos</option>
                        <option value="canada">Canadá</option>
                        <option value="mexico">México</option>
                        <!-- Otras opciones de países -->
                    </select>

                    <input type="date" placeholder="Seleccione una fecha" class="my-input">
                    <textarea name="mensaje" placeholder="Mensaje" class="my-input my-textarea"></textarea>

                    <input type="submit" value="Enviar mensaje" class="my-btn">
                </form>
            </div>
        </div>
    </div>
</main>


<!-- custom js -->