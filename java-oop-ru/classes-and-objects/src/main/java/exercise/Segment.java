package exercise;

// BEGIN
class Segment {
  Point beginPoint;
  Point midPoint;
  Point endPoint;

  Segment(Point beginPoint, Point endPoint) {
    this.beginPoint = beginPoint;
    this.endPoint = endPoint;

    this.midPoint = new Point(
        (beginPoint.getX() + endPoint.getX()) / 2,
        (beginPoint.getY() + endPoint.getY()) / 2);
  }

  public Point getBeginPoint() {
    return beginPoint;
  }

  public Point getEndPoint() {
    return endPoint;
  }

  public Point getMidPoint() {
    return midPoint;
  }
}
// END
