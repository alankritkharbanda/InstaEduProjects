import java.util.Stack;

public class Tanmay{
public static int isParenthesisMatch(String str) {
    if (str.charAt(0) == '{')
        return -1;

    Stack<Character> stack = new Stack<Character>();

    char c;int count=0;
    for(int i=0; i < str.length(); i++) {
        c = str.charAt(i);

        if(c == '(')
            stack.push(c);
        else if(c == '{')
            stack.push(c);
        else if(c == ')')
            if(stack.empty())
                return -1;
            else if(stack.peek() == '(')
                {stack.pop();count++;}
            else
                return -1;
        else if(c == '}')
            if(stack.empty())
                return -1;
            else if(stack.peek() == '{')
                {stack.pop();count++;}
            else
                return -1;
    }
    if(stack.empty())
    return count;
    return -1;
}

public static void main(String args[])
{
	System.out.println(isParenthesisMatch("(()(()))"));

}

}