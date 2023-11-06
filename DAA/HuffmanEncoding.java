import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class Main {

    public static void main(String[] args) {
        // Input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        // Generate Huffman codes
        Map<Character, String> huffmanCodes = generateHuffmanCodes(inputString);

        // Display Huffman codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<Character, String> generateHuffmanCodes(String inputString) {
        // Count the frequency of each character in the input string
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue of Huffman nodes
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Build the Huffman tree using a greedy strategy
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }

        // Generate Huffman codes
        HuffmanNode root = priorityQueue.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node != null) {
            if (node.data != '\0') {
                huffmanCodes.put(node.data, code);
            }
            generateCodes(node.left, code + "0", huffmanCodes);
            generateCodes(node.right, code + "1", huffmanCodes);
        }
    }
}
