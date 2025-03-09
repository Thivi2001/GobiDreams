<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\PackageController;
use App\Http\Controllers\BookingController;
use App\Http\Controllers\PhotoController;
use App\Http\Controllers\AdminController;
use Illuminate\Support\Facades\Route;

Route::post('/register', [AuthController::class, 'register']);
Route::post('/login', [AuthController::class, 'login']);
Route::middleware('auth:api')->group(function () {
    Route::post('/logout', [AuthController::class, 'logout']);
    Route::get('/profile', [AuthController::class, 'profile']);

    Route::apiResource('/packages', PackageController::class);

    Route::post('/bookings', [BookingController::class, 'store']);
    Route::get('/bookings', [BookingController::class, 'index']);
    Route::patch('/bookings/{booking}/mark-paid', [BookingController::class, 'markAsPaid']);

    Route::post('/photos/{booking}/upload', [PhotoController::class, 'upload']);
    Route::get('/photos/{booking}/download', [PhotoController::class, 'download']);

    Route::get('/admin/report', [AdminController::class, 'generateReport']);
});
