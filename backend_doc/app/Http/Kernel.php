<?php
protected $routeMiddleware = [
    'jwt.verify' => \App\Http\Middleware\VerifyJWT::class,
];
