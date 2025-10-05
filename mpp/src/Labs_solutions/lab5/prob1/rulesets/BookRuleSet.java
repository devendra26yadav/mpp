package Labs_solutions.lab5.prob1.rulesets;


import Labs_solutions.lab5.prob1.gui.BookWindow;

import java.awt.Component;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

    @Override
    public void applyRules(Component ob) throws RuleException {
        // TODO Auto-generated method stub
        BookWindow bookForm = (BookWindow )ob;

        String title = bookForm.getTitleValue().trim();
        String isbn = bookForm.getIsbnValue().trim();
        String price = bookForm.getPriceValue().trim();

        if(title.isEmpty() || isbn.isEmpty()|| price.isEmpty()){
            throw new RuleException("All fields must be non-empty.");
        }
        // B. ISBN must be numeric and 10 or 13 digits
        if (!isbn.matches("\\d+")) {
            throw new RuleException("ISBN must be numeric.");
        }
        if (!(isbn.length() == 10 || isbn.length() == 13)) {
            throw new RuleException("ISBN must be 10 or 13 digits.");
        }

        // C. If ISBN has 10 digits, first must be 0 or 1
        if (isbn.length() == 10) {
            if (!(isbn.startsWith("0") || isbn.startsWith("1"))) {
                throw new RuleException("10-digit ISBN must start with 0 or 1.");
            }
        }

        // D. If ISBN has 13 digits, first 3 must be 978 or 979
        if (isbn.length() == 13) {
            String prefix = isbn.substring(0, 3);
            if (!(prefix.equals("978") || prefix.equals("979"))) {
                throw new RuleException("13-digit ISBN must start with 978 or 979.");
            }
        }

        // E. Price must be a float with 2 decimal places
        if (!price.matches("\\d+\\.\\d{2}")) {
            throw new RuleException("Price must have two decimal places (e.g., 12.99).");
        }

        // F. Price must be > 0.49
        double priceVal = Double.parseDouble(price);
        if (priceVal <= 0.49) {
            throw new RuleException("Price must be greater than 0.49.");
        }

    }

}
