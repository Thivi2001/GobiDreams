<?php

namespace App\Http\Controllers;

use App\Models\Package;
use Illuminate\Http\Request;

class PackageController extends Controller
{
    // Fetch all packages
    public function index()
    {
        return response()->json(Package::all());
    }

    // Create a new package (Admin only)
    public function store(Request $request)
    {
        $this->authorize('admin'); // Ensure only admin can create packages

        $request->validate([
            'name' => 'required|string|max:255',
            'description' => 'required|string',
            'price' => 'required|numeric|min:0',
            'duration' => 'required|integer|min:1',
        ]);

        $package = Package::create($request->all());

        return response()->json(['message' => 'Package created', 'package' => $package], 201);
    }

    // Delete a package (Admin only)
    public function destroy(Package $package)
    {
        $this->authorize('admin');
        $package->delete();

        return response()->json(['message' => 'Package deleted']);
    }
}
