
<body onload="cargarApp()">

    <div class="cabecero">
        <div class="presupuesto">
            <div class="presupuesto_titulo">
                GASTOS ADMINISTRATIVOS DE COLEGIO
            </div>
            <div class="presupuesto_valor" id="presupuesto">+ 2,000.00</div>
            <div class="presupuesto_ingreso limpiarEstilos">
                <div class="presupuesto_ingreso--texto">INGRESOS MENSUALES</div>
                <div class="derecha">
                    <div class="presupuesto_ingreso--valor" id="ingresos">+ 4,000.00</div>
                    <div class="presupuesto_ingreso--porcentaje">&nbsp;</div>
                </div>
            </div>
            <div class="presupuesto_egreso limpiarEstilos">
                <div class="presupuesto_egreso--texto">PAGOS A LOS PROFESORES</div>
                <div class="derecha limpiarEstilos">
                    <div class="presupuesto_egreso--valor" id="egresos">- 1,900.00</div>
                    <div class="presupuesto_egreso--porcentaje" id="porcentaje">45%</div>
                </div>
            </div>
        </div>
    </div>

    <form id="forma" onsubmit="return false;">
        <div class="agregar">
            <div class="agregar_contenedor">
                <select class="agregar_tipo" id="tipo">
                    <option value="ingreso" selected>+</option>
                    <option value="egreso">-</option>
                </select>
                <input type="text" class="agregar_descripcion" placeholder="Agregar Descripción" id="descripcion"/>
                <input type="number" class="agregar_valor" placeholder="Valor" id="valor" step="any"/>
                <button type="submit" onclick="agregarDato()" class="btn btn-primary">Subir</button>
            </div>
        </div>
    </form>

    <div class="contenedor limpiarEstilos">
        <div class="ingreso">
            <h2 class="ingreso_titulo">PAGOS DEL COLEGIO</h2>
            <div id="lista-ingresos">
                <%-- Aquí se listarán los ingresos dinámicamente --%>
            </div>
        </div>
        <div class="egreso">
            <h2 class="egreso_titulo">PAGOS DE LOS PROFESORES</h2>
            <div id="lista-egresos">
                <%-- Aquí se listarán los egresos dinámicamente --%>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="views/admin/js/Dato.js"></script>
    <script src="views/admin/js/Ingreso.js"></script>
    <script src="views/admin/js/Egreso.js"></script>
    <script src="views/admin/js/app.js"></script>

</body>
