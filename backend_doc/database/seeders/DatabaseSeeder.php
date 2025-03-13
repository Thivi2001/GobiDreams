<?php

namespace Database\Seeders;

use App\Models\User;
use App\Models\Talent;
use App\Models\Package;
use App\Models\Booking;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // Create an Admin User
        User::factory()->create([
            'name' => 'Admin User',
            'email' => 'admin@gobidreams.com',
            'password' => Hash::make('password'),
            'role' => 'admin',
        ]);

        // Create a Regular Test User
        User::factory()->create([
            'name' => 'Test User',
            'email' => 'user@example.com',
            'password' => Hash::make('password'),
            'role' => 'user',
        ]);

        // Seed Talents (5 verified, 5 pending)
        Talent::factory(5)->create(['status' => 'verified']);
        Talent::factory(5)->create(['status' => 'pending']);

        // Seed Packages
        Package::factory()->createMany([
            [
                'name' => 'Basic Package',
                'description' => 'Includes 2-hour photography session.',
                'price' => 150.00,
                'duration' => 120,
            ],
            [
                'name' => 'Premium Package',
                'description' => 'Includes 4-hour photography session + editing.',
                'price' => 300.00,
                'duration' => 240,
            ],
            [
                'name' => 'Event Package',
                'description' => 'Full-day coverage for corporate events.',
                'price' => 800.00,
                'duration' => 480,
            ],
        ]);

        // Seed Bookings for the Test User
        $user = User::where('email', 'user@example.com')->first();
        $package = Package::first();

        Booking::factory(3)->create([
            'user_id' => $user->id,
            'package_id' => $package->id,
            'status' => 'confirmed',
        ]);
    }
}
