<?php

namespace App\Http\Controllers;

use App\Models\Booking;
use App\Models\Package;
use Illuminate\Http\Request;

class BookingController extends Controller
{
    // Customer books a session
    public function store(Request $request)
    {
        $request->validate([
            'package_id' => 'required|exists:packages,id',
            'booking_date' => 'required|date|after:today',
        ]);

        $booking = Booking::create([
            'user_id' => auth()->id(),
            'package_id' => $request->package_id,
            'booking_date' => $request->booking_date,
            'status' => 'pending',
            'payment_status' => 'pending',
        ]);

        return response()->json(['message' => 'Booking created', 'booking' => $booking], 201);
    }

    // Photographer or Admin marks payment as completed
    public function markAsPaid(Booking $booking)
    {
        $this->authorize('adminOrPhotographer');

        $booking->update(['payment_status' => 'paid']);

        return response()->json(['message' => 'Payment marked as paid']);
    }

    // View bookings (Admin, Photographer, Customer)
    public function index()
    {
        $user = auth()->user();

        if ($user->role == 'admin') {
            return response()->json(Booking::with('user', 'package')->get());
        }

        return response()->json($user->bookings()->with('package')->get());
    }
}
