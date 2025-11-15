import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Checkbox } from "@/components/ui/checkbox";
import { Progress } from "@/components/ui/progress";

const habits = [
  { id: 1, title: "Ejercicio matutino", completed: 5, total: 7, streak: 3 },
  { id: 2, title: "Meditar antes de dormir", completed: 6, total: 7, streak: 6 },
  { id: 3, title: "No usar pantallas 1h antes de dormir", completed: 4, total: 7, streak: 2 },
  { id: 4, title: "Dormir antes de las 11pm", completed: 3, total: 7, streak: 1 },
];

const todayHabits = [
  { id: 1, title: "Ejercicio matutino", done: true },
  { id: 2, title: "Tomar suficiente agua", done: false },
  { id: 3, title: "Meditar 10 minutos", done: true },
  { id: 4, title: "Evitar cafeína después de las 4pm", done: false },
];

const Habitos = () => {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Hábitos Saludables</h1>
        <p className="text-muted-foreground">Construye rutinas para mejor descanso</p>
      </div>

      <Card>
        <CardHeader>
          <CardTitle>Hábitos de Hoy</CardTitle>
          <CardDescription>Marca los hábitos que completaste hoy</CardDescription>
        </CardHeader>
        <CardContent className="space-y-4">
          {todayHabits.map((habit) => (
            <div key={habit.id} className="flex items-center space-x-3">
              <Checkbox id={`habit-${habit.id}`} defaultChecked={habit.done} />
              <label
                htmlFor={`habit-${habit.id}`}
                className="text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70"
              >
                {habit.title}
              </label>
            </div>
          ))}
        </CardContent>
      </Card>

      <div>
        <h2 className="text-xl font-semibold mb-4">Progreso Semanal</h2>
        <div className="grid gap-4 md:grid-cols-2">
          {habits.map((habit) => (
            <Card key={habit.id}>
              <CardHeader>
                <CardTitle className="text-base">{habit.title}</CardTitle>
                <CardDescription>
                  {habit.completed} de {habit.total} días esta semana
                </CardDescription>
              </CardHeader>
              <CardContent className="space-y-2">
                <Progress value={(habit.completed / habit.total) * 100} />
                <p className="text-sm text-muted-foreground">
                  🔥 Racha actual: {habit.streak} días
                </p>
              </CardContent>
            </Card>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Habitos;
