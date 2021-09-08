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