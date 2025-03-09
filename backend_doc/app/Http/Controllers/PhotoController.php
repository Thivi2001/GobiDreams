<?php

namespace App\Http\Controllers;

use App\Models\Booking;
use App\Models\Photo;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class PhotoController extends Controller
{
    // Photographer uploads photos
    public function upload(Request $request, Booking $booking)
    {
        $request->validate([
            'photos.*' => 'required|image|max:10240',
        ]);

        foreach ($request->file('photos') as $photo) {
            $path = $photo->store('photos', 'public');

            Photo::create([
                'booking_id' => $booking->id,
                'photo_url' => $path,
            ]);
        }

        return response()->json(['message' => 'Photos uploaded']);
    }

    // Customer downloads photos
    public function download(Booking $booking)
    {
        $this->authorize('customerOrPhotographer', $booking);

        $photos = $booking->photos->pluck('photo_url');

        return response()->json($photos);
    }
}
