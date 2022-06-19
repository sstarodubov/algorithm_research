-module(main).
-compile(nowarn_export_all).
-compile(export_all).

-record(user, {age, name}).
-record(robot, {
  name,
  type,
  details = []
}).
main() -> run(false)
.
run(R) ->
  if
    R == false -> io:format("false "), register(main_pr, self());
    R == true -> ok
  end,
  spawn(main, say_hello, []),
  receive
    {From, "alive"} -> io:format("he is alive"),
      io:format("~p~n", [From]);
    _ -> io:format("no mesgage\n")
  after 3000 ->
    io:format("timeout\n")
  end,
  run(true).


say_hello() -> timer:sleep(1000), main_pr ! {self(), "alive"}.

check_age(#user{age = Age}) when Age >= 18 -> allowed;
check_age(_) -> forbidden.

get_first_robot() -> #robot{name = "Hello", type = "world"}.

dfs_tree({Val, []}) -> print(Val);
dfs_tree({Val}) -> print(Val);
dfs_tree({Val, Leafs}) ->
  print(Val),
  lists:foreach(fun(Leaf) -> dfs_tree(Leaf) end, Leafs).

dfs_binary_tree({}) -> end_path;
dfs_binary_tree({Val}) when is_number(Val) -> print(Val);
dfs_binary_tree({Val, One_Leaf}) ->
  print(Val),
  dfs_binary_tree(One_Leaf);
dfs_binary_tree({Val, Left, Right}) ->
  print(Val),
  dfs_binary_tree(Left),
  dfs_binary_tree(Right).

sword() -> erlang:error(cut_arm).

black_knight(Attack) when is_function(Attack) ->

  try Attack() of
    ok -> io:format("OK");
    _ -> io:format("some")
  catch
    error:fck -> io:format("faaaaa");
    throw:punch -> print("panch");
    throw:slice -> print("It is but a scratch.");
    exit:fck -> io:format("I've had worse.");
    exit:cut_leg -> print("Come on you pansy!")
  end.


prepare_alarm(Room) ->
  io:format("~s is prepared", [Room]),
  fun() -> io:format("~s alarms", [Room]) end.

inc(X) -> X + 1.
map(_, []) -> [];
map(Fn, [H | T]) -> [Fn(H) | map(Fn, T)].

compound(Fn, A, B) -> Fn(A, B).

zip([], []) -> [];
zip([X | XS], [Y | YS]) -> [{X, Y} | zip(XS, YS)].

duplicate(El, Times) -> duplicate(El, Times, []).
duplicate(_, 0, List) -> List;
duplicate(El, Times, List) -> duplicate(El, Times - 1, [El | List]).


len([], Acc) -> Acc;
len([_ | Tail], Acc) -> len(Tail, Acc + 1).
len(List) when is_list(List) -> len(List, 0).

print([X | []]) -> print(X);
print([Head | Tail]) ->
  print(Head),
  print(Tail);

print(El) when is_tuple(El) -> print(tuple_to_list(El));
print(Num) when is_integer(Num) -> io:format(integer_to_list(Num));
print(Str) when is_bitstring(Str) -> io:format(Str);
print(Atom) when is_atom(Atom) -> io:format(atom_to_list(Atom));
print(_) -> io:format("").

head([H | _]) -> H.
tail([_ | Tail]) -> Tail.
