<?php

namespace Database\Factories;

use App\Models\Talent;
use Illuminate\Database\Eloquent\Factories\Factory;

class TalentFactory extends Factory
{
    protected $model = Talent::class;

    public function definition()
    {
        return [
            'name' => $this->faker->name(),
            'portfolio_url' => $this->faker->url(),
            'status' => 'pending',
        ];
    }
}
