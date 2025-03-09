<?php

namespace App\Http\Controllers;

use App\Models\Booking;
use Illuminate\Http\Request;

class AdminController extends Controller
{
    // Generate booking report
    public function generateReport()
    {
        $this->authorize('admin');

        $report = Booking::with(['user', 'package'])->get();

        return response()->json($report);
    }
}
