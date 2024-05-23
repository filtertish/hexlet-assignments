package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
class Tag {
    private final String tagName;
    private final Map<String, String> attributes;
    private final String tagBody;
    private final List<Tag> tagChildren;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.tagBody = null;
        this.tagChildren = null;
    }

    public Tag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> tagChildren) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.tagBody = tagBody;
        this.tagChildren = tagChildren;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getTagBody() {
        return tagBody;
    }

    public List<Tag> getTagChildren() {
        return tagChildren;
    }
}
// END
