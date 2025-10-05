package Labs_solutions.lab5.prob1.rulesets;

import Labs_solutions.lab5.prob1.gui.CDWindow;

import java.awt.*;

/**
 * Rules:
 *  1. All fields must be nonempty
 *  2. Price must be a floating point number with two decimal places
 *  3. Price must be a number greater than 0.49.
 */

public class CDRuleSet implements RuleSet {

    @Override
    public void applyRules(Component ob) throws RuleException {
        // TODO Auto-generated method stub
        CDWindow cdForm = (CDWindow) ob;

        String artist = cdForm.getArtistValue().trim();
        String title = cdForm.getTitleValue().trim();
        String price = cdForm.getPriceValue().trim();

        // A. All fields must be nonempty
        if (artist.isEmpty() || title.isEmpty() || price.isEmpty()) {
            throw new RuleException("All fields must be non-empty.");
        }

        // B. Price must be a float with 2 decimal places
        if (!price.matches("\\d+\\.\\d{2}")) {
            throw new RuleException("Price must have two decimal places (e.g., 9.99).");
        }

        // C. Price must be > 0.49
        double priceVal = Double.parseDouble(price);
        if (priceVal <= 0.49) {
            throw new RuleException("Price must be greater than 0.49.");
        }

    }

}
