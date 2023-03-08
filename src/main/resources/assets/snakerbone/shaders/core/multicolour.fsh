#version 150

uniform float Time;

in vec2 textureProjection;
out vec4 fragColor;

void main(void)
{
    vec2 resolution = vec2(256, 256);

    vec2 coords = 6. * (gl_FragCoord.xy / resolution.xy);

    for (int n = 1; n < 8; n++)
    {
        float t = Time;
        float i = float(n);

        coords += vec2(0.7 / i * sin(i * coords.y + t + 0.3 * i) + 0.8, 0.4 / i * sin(i * coords.x + t + 0.3 * i) + 1.6);
    }

    vec3 colour = vec3(0.5 * sin(coords.x) + 0.5, 0.5 * sin(coords.y) + 0.5, sin(coords.x + coords.y));

    fragColor = vec4(colour, 1.0);
}