#version 150

uniform float Time;
uniform vec3 Colour;
uniform bool Background;

in vec2 textureProjection;
out vec4 fragColor;

float stars(vec2 uv, float scale)
{
    float weight = smoothstep(20.0, 0.0, - uv.y * (scale / 10.0));

    if (weight < 0.1) return 0.0;

    uv += (Time / 0.3) / scale;
    uv.y += Time * 0.00000001 / scale;
    uv.x += sin(uv.y + Time * 0.5) / scale;
    uv *= scale;

    vec2 speed = floor(uv), frag = fract(uv), projection;

    float amount = 3.0, direction;

    projection = 0.5 + 0.35 * sin(11.0 * fract(sin((speed + projection + scale) * mat2(7, 3, 6, 5)) * 5.0)) - frag;

    direction = length(projection);

    amount = min(direction, amount);
    amount = smoothstep(0.0, amount, sin(frag.x + frag.y) * 0.01);

    return amount * weight;
}

void main(void)
{
    vec2 resolution = vec2(256, 256);
    vec2 uv = (gl_FragCoord.xy * 2.0 - resolution.xy) / min(resolution.x, resolution.y);

    float alpha = Background ? 0.5 : 1.0;
    float rgb = smoothstep(1.0, 0.3, clamp(uv.y * 0.0 + 1.0, 0.0, alpha));

    rgb += stars(uv, 15.0) * 0.8;
    rgb += stars(uv, 10.0);
    rgb += stars(uv, 8.0);
    rgb += stars(uv, 6.0);
    rgb += stars(uv, 5.0);

    vec3 finalColour = Colour * rgb;

    // gl_FragColor = vec4(finalColour, 1);
    fragColor = vec4(finalColour, 1);
}