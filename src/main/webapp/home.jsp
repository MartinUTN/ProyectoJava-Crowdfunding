<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ImpulsaMe - Crowdfunding</title>

    <link rel="icon" href="./assets/simbolo-dinero.png">

    <link href="style/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="style/home.css">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/footer.css">
</head>
<body>
    <div class="container-fluid p-0">
        <jsp:include page="header.html" />

        <main>
            <div class="container col-xxl-8 px-4 py-5">
                <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
                    <div class="col-10 col-sm-8 col-lg-6">
                        <img src="assets/crowdfunding-impulsame-logo.png" class="d-block mx-lg-auto img-fluid" alt="Financia Tus Sueños" width="700" height="500" loading="lazy">
                    </div>
                    <div class="col-lg-6">
                        <h1 class="display-5 fw-bold text-dark lh-1 mb-3">Financia Tus Sueños</h1>
                        <p class="lead text-muted">
                            Bienvenido a nuestra plataforma de crowdfunding. Aquí puedes encontrar proyectos innovadores para apoyar o puedes crear tu propio proyecto y buscar el financiamiento que necesitas para hacerlo realidad.
                        </p>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-start mt-4">
                            <a href="#" class="btn btn-primary btn-lg px-4 me-md-2 fw-bold">Explorar Proyectos</a>
                            <a href="#" class="btn btn-outline-secondary btn-lg px-4 fw-bold">Crear Proyecto</a>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        
        <jsp:include page="footer.html" />
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>