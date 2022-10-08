import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    // representa o byte 1111111 - valor util para essas operações
    private final long MASK = 127;

    List<String> encode(List<Long> numbers) {

        List<String> ans = new ArrayList<>();
        numbers.forEach(number -> ans.addAll(this.encodeNumber(number)));

        return ans;
    }

    List<String> decode(List<Long> bytes) {

        List<String> ans = new ArrayList<>();
        long sum = 0;

        for (int i = 0; i < bytes.size(); i++) {

            long currentByte = bytes.get(i);

            // 'abre espaço' para o próximo byte
            sum = sum << 7;

            // 'retira' os 7 ultimos bytes do valor e os
            // adiciona à soma corrente
            sum = sum | (currentByte & MASK);

            // pega o bit mais significativo, testa o
            // seu valor e performa as operações necessárias
            long msb = currentByte >>> 7;
            if (msb == 0) {
                ans.add("0x" + Long.toHexString(sum));
                sum = 0;
            } else if (msb == 1 && i == bytes.size() - 1) {
                throw new IllegalArgumentException("Invalid variable-length quantity encoding");
            }

        }

        return ans;
    }

    private List<String> encodeNumber(long number) {

        // Não precisa fazer nada caso numero seja menor
        // 128 (um byte).
        if (number < 128) {
            return List.of("0x" + Long.toHexString(number));
        }

        // Caso o número seja maior que 128
        List<String> ans = new ArrayList<>();

        while (number > 0) {

            // pego os 7 ultimos bits do numero
            long current = number & MASK;

            // adiciono o 'most significant bit'
            // caso seja necessário
            if (!ans.isEmpty()) {
                current = current | (MASK + 1);
            }

            // salvo o número gerado pelos bits
            // processados
            ans.add(0, "0x" + Long.toHexString(current));

            // 'retiro' do número os bits já utilizados
            number = number >>> 7;
        }

        return ans;
    }
}
