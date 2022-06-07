-module(main).
%%-export([main/0]).
-compile(nowarn_export_all).
-compile(export_all).

main() -> print(len([1,2,3,4])).

len([], Acc) -> Acc;
len([_ | Tail], Acc) -> len(Tail, Acc + 1).
len(List) when is_list(List) -> len(List, 0).

print([X | []]) -> print(X);
print([Head | Tail]) ->
  print(Head),
  print(Tail);

print(Num) when is_integer(Num) -> io:format(integer_to_list(Num));
print(Str) when is_bitstring(Str) -> io:format(Str);
print(Atom) when is_atom(Atom) -> io:format(atom_to_list(Atom));
print(_) -> io:format("").


head([H | _]) -> H.
tail([_ | Tail]) -> Tail.

greet(male, Name) -> io:format("Hello, Mr. ~s", [Name]);
greet(female, Name) -> io:format("Hello, Mrs. ~s", [Name]);
greet(_, Name) -> io:format("Hello, ~s", [Name]).
