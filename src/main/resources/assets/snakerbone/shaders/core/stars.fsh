#version 150

uniform float Time;
uniform vec3 Colour;
uniform bool Background;

in vec2 textureProjection;
out vec4 fragColor;

float sStars(vec2 sVecIn, float sNumIn)
{
    float sWeight = smoothstep(20.0, 0.0, -sVecIn.y * (sNumIn / 10.0));

    if (sWeight < 0.1) return 0.0;

    sVecIn += (Time / 0.3) / sNumIn;
    sVecIn.y += Time * 0.00000001 / sNumIn;
    sVecIn.x += sin(sVecIn.y + Time * 0.5) / sNumIn;
    sVecIn *= sNumIn;

    vec2 sSpeed = floor(sVecIn), sFrag = fract(sVecIn), sProjection;

    float sAmount = 3.0, sDelta;

    sProjection = 0.5 + 0.35 * sin(11.0 * fract(sin((sSpeed + sProjection + sNumIn) * mat2(7, 3, 6, 5)) * 5.0)) - sFrag;

    sDelta = length(sProjection);

    sAmount = min(sDelta, sAmount);
    sAmount = smoothstep(0.0, sAmount, sin(sFrag.x + sFrag.y) * 0.01);

    return sAmount * sWeight;
}

void main(void)
{
    vec2 sResolution = vec2(256, 256);
    vec2 sProjection = (gl_FragCoord.xy * 2.0 - sResolution.xy) / min(sResolution.x, sResolution.y);

    float sAlpha = Background ? 0.5 : 1.0;
    float sRGB = smoothstep(1.0, 0.3, clamp(sProjection.y * 0.0 + 1.0, 0.0, sAlpha));

    sRGB += sStars(sProjection, 15.0) * 0.8;
    sRGB += sStars(sProjection, 10.0);
    sRGB += sStars(sProjection, 8.0);
    sRGB += sStars(sProjection, 6.0);
    sRGB += sStars(sProjection, 5.0);

    vec3 sColour = Colour * sRGB;

    // gl_FragColor = vec4(sColour, 1);
    fragColor = vec4(sColour, 1);
}