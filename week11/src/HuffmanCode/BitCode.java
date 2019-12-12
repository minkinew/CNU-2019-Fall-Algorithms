package HuffmanCode;

public class BitCode {
    char alpha;
    StringBuffer code;

    public BitCode(char alpha, StringBuffer code) {
        this.alpha = alpha;
        this.code = code;
    }

    @Override
    public String toString() {
        return alpha + "," + code;
    }
}