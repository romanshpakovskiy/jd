package by.it.romanshpakovskiy.tasks.jd02_04;

interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other) throws CalcException;
}