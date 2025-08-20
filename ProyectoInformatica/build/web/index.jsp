<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ventana de Admin</title>
    <link rel="stylesheet" href="Styles/admin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav>
        <ul>
            <li><a href="Controlador?menu=Dispositivos&accion=Listar" target="contenido">Dispositivos Periféricos</a></li>
            <li><a href="Controlador?menu=Ventas&accion=Listar" target="contenido">Ventas</a></li>
        </ul>
    </nav>

    <div class="main-container" style="display: flex; flex-direction: column; height: calc(100vh - 60px); gap: 10px; padding: 10px 20px;">
        <div class="overlay-card" style="flex: 0 0 auto; max-height: 400px; overflow: hidden; border-radius: 12px; box-shadow: 0 4px 20px rgba(0,0,0,0.3);">
            <div id="carouselExample" class="carousel slide h-100">
                <div class="carousel-inner h-100">
                    <div class="carousel-item active">
                        <img src="img/PC.jpg" class="d-block w-100 h-100" style="object-fit: cover;" alt="Imagen 1">
                    </div>
                    <div class="carousel-item">
                        <img src="img/PC3.jpg" class="d-block w-100 h-100" style="object-fit: cover;" alt="Imagen 2">
                    </div>
                    <div class="carousel-item">
                        <img src="img/PC4.jpg" class="d-block w-100 h-100" style="object-fit: cover;" alt="Imagen 3">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>

        <div class="contenido" style="flex: 1 1 auto; margin-top: 10px;">
            <iframe name="contenido" style="width: 100%; height: 100%; border: none; border-radius: 10px; box-shadow: 0 4px 20px rgba(0,0,0,0.3);"></iframe>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>