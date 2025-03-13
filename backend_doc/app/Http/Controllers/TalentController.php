<?php

namespace App\Http\Controllers;

use App\Models\Talent;
use Illuminate\Http\Request;

class TalentController extends Controller
{
    public function index()
    {
        $talents = Talent::where('status', 'verified')->get();
        return response()->json($talents);
    }

    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'portfolio_url' => 'required|url',
            'status' => 'in:pending,verified,rejected',
        ]);

        $talent = Talent::create($request->all());
        return response()->json($talent, 201);
    }

    public function verify($id)
    {
        $talent = Talent::findOrFail($id);
        $talent->update(['status' => 'verified']);
        return response()->json(['message' => 'Talent verified successfully']);
    }

    public function destroy($id)
    {
        Talent::findOrFail($id)->delete();
        return response()->json(['message' => 'Talent deleted successfully']);
    }
}
