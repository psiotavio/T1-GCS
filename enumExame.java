public enum enumExame {
    RaioX(1),
    Tomografia(2), 
    Mamografia(3), 
    Colonoscopia(4), 
    Endoscopia(5), 
    Hemograma(6), 
    Audiometria(7), 
    Espirometria(8), 
    Ultrassonografia(9), 
    Eletrocardiograma(10);

    private int valor;

    private enumExame (int valor)
    {
        this.valor = valor;
    }

    public int getValor()
    {
        return valor;
    }

    public static enumExame getEnumExame(int n)
    {
        switch (n)
        {
            case 1: return enumExame.RaioX;
            case 2: return enumExame.Tomografia;
            case 3: return enumExame.Mamografia;
            case 4: return enumExame.Colonoscopia;
            case 5: return enumExame.Endoscopia;
            case 6: return enumExame.Hemograma;
            case 7: return enumExame.Audiometria;
            case 8: return enumExame.Espirometria;
            case 9: return enumExame.Ultrassonografia;
            case 10: return enumExame.Eletrocardiograma;
            default: return null;
        }
    }
}

