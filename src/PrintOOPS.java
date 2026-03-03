
public class PrintOOPS {

    public static class CharacterPatternMap {

        private char character;
        private String[] pattern;

        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap getCharacterPattern(
            char ch, CharacterPatternMap[] patterns) {

        for (CharacterPatternMap pattern : patterns) {
            if (pattern.getCharacter() == ch) {
                return pattern;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        String[] oPattern = {
                " ***** ",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                " ***** "
        };

        String[] pPattern = {
                " ***** ",
                "*     *",
                "*     *",
                " ***** ",
                "*      ",
                "*      ",
                "*      "
        };

        String[] sPattern = {
                " ***** ",
                "*      ",
                "*      ",
                " ***** ",
                "      *",
                "      *",
                " ***** "
        };

        CharacterPatternMap[] patterns = {
                new CharacterPatternMap('O', oPattern),
                new CharacterPatternMap('P', pPattern),
                new CharacterPatternMap('S', sPattern)
        };

        String word = "OOPS";

        for (int row = 0; row < 7; row++) {

            StringBuilder line = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {

                CharacterPatternMap pattern =
                        getCharacterPattern(word.charAt(i), patterns);

                if (pattern != null) {
                    line.append(pattern.getPattern()[row]).append("   ");
                }
            }

            System.out.println(line);
        }
    }
}