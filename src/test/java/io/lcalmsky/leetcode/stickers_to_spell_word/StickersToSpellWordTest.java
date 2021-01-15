package io.lcalmsky.leetcode.stickers_to_spell_word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StickersToSpellWordTest {
    @Test
    public void givenStickersAndTargetWord_whenSpellOutTargetUsingStickers_thenCorrect() {
        assertAll(
                () -> test(new String[]{"with", "example", "science"}, "thehat", 3),
                () -> test(new String[]{"notice", "possible"}, "basicbasic", -1)
        );
    }

    private void test(String[] stickers, String target, int expected) {
        // when
        Solution stickersToSpellWord = new Solution();
        int actual = stickersToSpellWord.minStickers(stickers, target);

        // then
        assertEquals(expected, actual);
    }
}
