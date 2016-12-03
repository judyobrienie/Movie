package utils;
/**
 * @author Judy
 * Serializer Interface that was supplied as part of the assignment.
 *
 */
public interface Serializer
{
  void push(Object o);
  Object pop();
  void write() throws Exception;
  void read() throws Exception;
}