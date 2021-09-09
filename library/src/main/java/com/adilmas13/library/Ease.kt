package com.adilmas13.library

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

interface Ease {
    fun calculate(x: Double): Double
}

/* Linear*/
class Linear : Ease {
    override fun calculate(x: Double) = x
}

/*Sine*/
class EaseInSine : Ease {
    override fun calculate(x: Double) = 1f - cos((x * PI) / 2f)
}

class EaseOutSine : Ease {
    override fun calculate(x: Double) = sin((x * PI) / 2f)
}

class EaseInOutSine : Ease {
    override fun calculate(x: Double) = -(cos(PI * x) - 1) / 2f
}

/*Cubic*/
class EaseInCubic : Ease {
    override fun calculate(x: Double) = x * x * x
}

class EaseOutCubic : Ease {
    override fun calculate(x: Double) = 1 - (1 - x).pow(3)
}

class EaseInOutCubic : Ease {
    override fun calculate(x: Double) =
        if (x < 0.5) 4 * x * x * x else 1 - (-2 * x + 2).pow(3.0) / 2
}

/*Quint*/
class EaseInQuint : Ease {
    override fun calculate(x: Double) = x * x * x * x * x
}

class EaseOutQuint : Ease {
    override fun calculate(x: Double) = 1 - (1 - x).pow(5);
}

class EaseInOutQuint : Ease {
    override fun calculate(x: Double) =
        if(x < 0.5)  16 * x * x * x * x * x else 1 - (-2 * x + 2).pow(5) / 2;
}

/*Circ*/
class EaseInCirc : Ease {
    override fun calculate(x: Double) = 1 - Math.sqrt(1 - Math.pow(x, 2.0));
}

class EaseOutCirc : Ease {
    override fun calculate(x: Double) = Math.sqrt(1 - Math.pow(x - 1, 2.0));
}

class EaseInOutCirc : Ease {
    override fun calculate(x: Double) =
       if ( x < 0.5)
     (1 - Math.sqrt(1 - Math.pow(2 * x, 2.0))) / 2
    else (Math.sqrt(1 - Math.pow(-2 * x + 2, 2.0)) + 1) / 2;
}

/*Elastic*/
class EaseInElastic : Ease {
    override fun calculate(x: Double) = when (x) {
        0.0 -> 0.0
        1.0 -> 1.0
        else -> {
            val c4 = (2 * PI) / 3
            (-1 * ((2.0).pow(10.0 * x - 10)) * sin((x * 10 - 10.75) * c4))
        }
    }
}

class EaseOutElastic : Ease {
    override fun calculate(x: Double) = when (x) {
        0.0 -> 0.0
        1.0 -> 1.0
        else -> {
            val c4 = (2 * PI) / 3
            (2.0.pow(-10.0 * x) * sin((x * 10 - 0.75) * c4) + 1)
        }
    }
}

class EaseInOutElastic : Ease {
    override fun calculate(x: Double): Double {
        val c5 = (2 * PI) / 4.5
        return when {
            (x == 0.0) -> 0.0
            (x == 1.0) -> 1.0
            (x < 0.5) -> (-(2.0.pow(20.0 * x - 10) * sin((20 * x - 11.125) * c5)) / 2)
            else -> ((2.0.pow(-20.0 * x + 10) * sin((20 * x - 11.125) * c5)) / 2 + 1)
        }
    }
}

/*Quad*/
class EaseInQuad : Ease {
    override fun calculate(x: Double) = x * x
}

class EaseOutQuad : Ease {
    override fun calculate(x: Double) = 1 - (1 - x) * (1 - x)
}

class EaseInOutQuad : Ease {
    override fun calculate(x: Double) =
        if(x < 0.5)  2 * x * x else 1 - Math.pow(-2 * x + 2, 2.0) / 2;
}

/*Quart*/
class EaseInQuart : Ease {
    override fun calculate(x: Double) = x * x * x * x;
}

class EaseOutQuart : Ease {
    override fun calculate(x: Double) = 1 - Math.pow(1 - x, 4.0);
}

class EaseInOutQuart : Ease {
    override fun calculate(x: Double) =
        if (x < 0.5)  8 * x * x * x * x else 1 - Math.pow(-2 * x + 2, 4.0) / 2;
}

/*Expo*/
class EaseInExpo : Ease {
    override fun calculate(x: Double) = if (x == 0.0) 0.0 else Math.pow(2.0, 10 * x - 10)
}

class EaseOutExpo : Ease {
    override fun calculate(x: Double) = if (x == 1.0) 1.0 else 1 - Math.pow(2.0, -10 * x);
}

class EaseInOutExpo : Ease {
    override fun calculate(x: Double) =
       when{
           (x==0.0) -> 0.0
           (x==1.0) -> 1.0
           (x < 0.5) -> Math.pow(2.0, 20 * x - 10) / 2
           else -> (2 - Math.pow(2.0, -20 * x + 10)) / 2
       }
}

/*Back*/
class EaseInBack : Ease {
    override fun calculate(x: Double): Double {
        val c1 = 1.70158;
        val c3 = c1 + 1
        return c3 * x * x * x - c1 * x * x;
    }
}

class EaseOutBack : Ease {
    override fun calculate(x: Double) : Double{
        val c1 = 1.70158;
        val c3 = c1 + 1;
        return 1 + c3 * Math.pow(x - 1, 3.0) + c1 * Math.pow(x - 1, 2.0);
    }
}

class EaseInOutBack : Ease {
    override fun calculate(x: Double) : Double{
        val c1 = 1.70158;
        val c2 = c1 * 1.525;
        return if (x < 0.5) (Math.pow(2 * x, 2.0) * ((c2 + 1) * 2 * x - c2)) / 2.0 else (Math.pow(2 * x - 2, 2.0) * ((c2 + 1) * (x * 2 - 2) + c2) + 2) / 2
    }
}

/*Bounce*/
class EaseInBounce : Ease {
    override fun calculate(x: Double) = 1 - EaseOutBounce().calculate(1 - x);
}

class EaseOutBounce : Ease {
    override fun calculate(x: Double) : Double{
        val n1 = 7.5625;
        val d1 = 2.75;
        return when{
            (x < 1 / d1) -> n1 * x * x
            (x < 2 / d1) -> {
                val tempX = x - 1.5 / d1
                return n1 * tempX * tempX + 0.75
            }
            (x < 2.5 / d1) -> {
                val tempX = x - 2.25 / d1
               return n1 * tempX * tempX + 0.9375
            }
            else -> {
                val tempX = x - 2.625 / d1
               return n1 * tempX * tempX + 0.984375
            }
        }
    }
}

class EaseInOutBounce : Ease {
    override fun calculate(x: Double) = if (x < 0.5) (1 - EaseOutBounce().calculate(1 - 2 * x)) / 2 else (1 + EaseOutBounce().calculate(2 * x - 1)) / 2
}