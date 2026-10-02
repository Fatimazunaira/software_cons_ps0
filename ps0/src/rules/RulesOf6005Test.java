/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));

        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * Tests that code written as coursework cannot be reused.
     */
    @Test
    public void testCourseWorkCodeNotAllowed() {
        assertFalse("Expected false: code written as 6.005 coursework",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * Tests that required implementation must be written by yourself.
     */
    @Test
    public void testImplementationRequiredMustBeSelfWritten() {
        assertFalse("Expected false: required implementation from another source",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
}