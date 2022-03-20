package leetcode;

import java.util.ArrayList;
import java.util.List;

class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length > 0 && maxWidth > 0) {
            for (int i = 0; i < words.length;) {
                int lineLength = words[i].length();
                int j = i + 1;
                for (; j < words.length; j++) {
                    if (lineLength + words[j].length() + (j - i) <= maxWidth) {
                        lineLength += words[j].length();
                    } else {
                        break;
                    }
                }
                int numOfWords = j - i;
                int diff = maxWidth - lineLength;
                if (numOfWords == 1 || j >= words.length) {
                    res.add(leftJustified(i, j, words, diff));
                } else {
                    res.add(middleJustified(i, j, words, diff));
                }
                i = j;
            }
        }
        return res;
    }

    public String leftJustified(int i, int j, String[] words, int diff) {
        int spacesOnRight = diff - (j - i - 1);
        int spaceBetween = j - i - 1;
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            sb.append(words[i]);
            if (spaceBetween > 0) {
                sb.append(" ");
                spaceBetween--;
            }
            i++;
        }
        while (spacesOnRight > 0) {
            sb.append(" ");
            spacesOnRight--;
        }
        return sb.toString();
    }

    public String middleJustified(int i, int j, String[] words, int diff) {
        int spaceSlots = j - i - 1;
        int spaceBetween = diff / spaceSlots;
        int leftSpaces = diff % spaceSlots;
        StringBuilder sb = new StringBuilder();
        int k = i;
        while (k < j) {
            int spaces = spaceBetween;
            sb.append(words[k]);
            while (k < j - 1 && spaces > 0) {
                sb.append(" ");
                spaces--;
            }
            if (leftSpaces > 0 && k < j - 1) {
                sb.append(" ");
                leftSpaces--;
            }
            k++;
        }
        return sb.toString();
    }
}
