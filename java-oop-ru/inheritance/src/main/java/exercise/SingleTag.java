package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        var result = new StringBuilder("<");

        result.append(getTagName());
        getAttributes().forEach((key, value) -> result.append(String.format(" %s=\"%s\"", key, value)));
        result.append(">");

        return result.toString();
    }
}
// END
