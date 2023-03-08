#version 150

uniform float Time;

in vec2 textureProjection;
out vec4 fragColor;

mat3 rotX(float a)
{
    float c = cos(a);
    float s = sin(a);

    return mat3(1, 0, 0, 0, c, -s, 0, s, c);
}

mat3 rotY(float a)
{
    float c = cos(a);
    float s = sin(a);

    return mat3(c, 0, -s, 0, 1, 0, s, 0, c);
}

float random(vec2 pos)
{
    return fract(sin(dot(pos.xy, vec2(12.9898, 78.233))) * 43758.5453123);
}

float noise(vec2 pos)
{
    vec2 i = floor(pos);
    vec2 f = fract(pos);

    float a = random(i + vec2(0.0, 0.0));
    float b = random(i + vec2(1.0, 0.0));
    float c = random(i + vec2(0.0, 1.0));
    float d = random(i + vec2(1.0, 1.0));

    vec2 u = f * f * (3.0 - 2.0 * f);

    return mix(a, b, u.x) + (c - a) * u.y * (1.0 - u.x) + (d - b) * u.x * u.y;
}

float fbm(vec2 pos)
{
    float v = 0.0;
    float a = 0.5;

    vec2 shift = vec2(100.0);

    mat2 rot = mat2(cos(0.5), sin(0.5), -sin(0.5), cos(0.5));

    for (int i=0; i<16; i++)
    {
        v += a * noise(pos);

        pos = rot * pos * 2.0 + shift;

        a *= 0.5;
    }

    return v;
}

void main(void)
{
    vec2 resolution = vec2(256, 256);

    vec2 p = (gl_FragCoord.xy * 2.0 - resolution.xy) / min(resolution.x, resolution.y);

    float t = 1.0, d;
    float time2 = 5.0 * Time / 5.0;

    vec2 q = vec2(1.0);

    q.x = fbm(p + 0.00 * time2);
    q.y = fbm(p + vec2(1.0));

    vec2 r = vec2(0.0);

    r.x = fbm(p + 7.0 * q + vec2(1.7, 9.2) + 0.15 * time2);
    r.y = fbm(p + 2.0 * q + vec2(8.3, 2.8) + 0.126 * time2);

    float f = fbm(p + r);

    vec2 uv = gl_FragCoord.xy/resolution.xy - 0.5;

    uv.x *= (resolution.x/resolution.y);

    vec3 colour = vec3(0.0);

    colour = vec3(fbm(uv * (1.0+0.2*sin(Time * 0.666))));

    colour = mix(colour, vec3(0.5 + 0.5*sin(Time+uv.yxx+vec3(0, 2, 4))), 0.9);

    colour = mix(colour, vec3(1.0), clamp(length(r.x), 0.0, 1.0));

    fragColor = vec4(colour, 1.0);
}