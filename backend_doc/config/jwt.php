<?php

return [
    'secret' => env('JWT_SECRET'),
    'ttl' => 60, // Token expiration in minutes
    'refresh_ttl' => 20160, // Refresh token expiration (14 days)
    'algo' => 'HS256',
    'required_claims' => ['iss', 'iat', 'exp', 'nbf', 'sub', 'jti'],
    'blacklist_enabled' => env('JWT_BLACKLIST_ENABLED', true),
];
