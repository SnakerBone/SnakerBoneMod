#version 150

uniform float Time;

in vec2 textureProjection;
out vec4 fragColor;

void main() {

    vec2 resolution = vec2(256, 256);
    vec2 position = (2.0 * gl_FragCoord.xy - resolution) / max(resolution.x, resolution.y);

    for (int i = 1;i < 40; i++)
    {
        vec2 newPosition = position;

        newPosition.x += 0.6 / float(i) * sin(float(i) * position.y + Time / 25.0 + 0.3 * float(i)) + 25.0 + 5.0;
        newPosition.y += 0.6 / float(i) * sin(float(i) * position.x + Time / 25.0 + 0.3 * float(i + 10)) - 25.0 + 5.0;

        position = newPosition;

    }

    vec3 finalColour = vec3(0.7 * sin(3.0 * position.x) + 0.7, 0.7 * sin(3.0 * position.y) + 0.7, sin(position.x + position.y));

    fragColor = vec4(finalColour, 1.0);
}