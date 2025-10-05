package Labs_solutions.lab5.prob1.rulesets;


import Labs_solutions.lab5.prob1.gui.BookWindow;
import Labs_solutions.lab5.prob1.gui.CDWindow;

import java.awt.Component;
import java.util.HashMap;

final public class RuleSetFactory {
    private RuleSetFactory(){}
    static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
    static {
        map.put(CDWindow.class,new CDRuleSet());
        map.put(BookWindow.class,new BookRuleSet());
    }

    public static RuleSet getRuleSet(Component c) {
        RuleSet rules = map.get(c.getClass());
        if (rules == null) {
            throw new IllegalArgumentException("No RuleSet found for this component");
        }
        return rules;
    }
}