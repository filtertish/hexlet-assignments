package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
class PairedTag extends Tag {
    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> tagChildren) {
        super(tagName, attributes, tagBody, tagChildren);
    }

    @Override
    public String toString() {
        var result = new StringBuilder("<");

        result.append(getTagName());
        getAttributes().forEach((key, value) -> result.append(String.format(" %s=\"%s\"", key, value)));
        result.append(">");

        result.append(getTagBody());
        getTagChildren().forEach(tag -> result.append(tag.toString()));
        result.append(String.format("</%s>", getTagName()));

        return result.toString();
    }
}
// END
