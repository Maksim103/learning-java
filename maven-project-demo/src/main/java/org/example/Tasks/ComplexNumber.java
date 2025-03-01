package org.example.Tasks;

class ComplexNumber {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        // a.equals(b) must return true
        // a.hashCode() must be equal to b.hashCode()

        System.out.println(a.equals(b));
        System.out.println(a.hashCode() + " - a.hashCode()");
        System.out.println(b.hashCode() + " - b.hashCode()");
    }

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime*result + (int)Double.doubleToLongBits(getIm());
        result = prime*result + (int)Double.doubleToLongBits(getRe());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass() ) {
            return false;
        }

        ComplexNumber complexNumber = (ComplexNumber) obj;
        return Double.compare(complexNumber.im, getIm()) == 0 && Double.compare(complexNumber.re, getRe()) == 0;
    }
}
