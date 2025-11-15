import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Progress } from "@/components/ui/progress";
import { Button } from "@/components/ui/button";
import { CheckCircle2, Circle, Target } from "lucide-react";

const goals = [
  {
    id: 1,
    title: "Dormir 8 horas diarias",
    progress: 75,
    current: 21,
    target: 28,
    unit: "días",
    status: "active",
  },
  {
    id: 2,
    title: "Calidad de sueño >8",
    progress: 60,
    current: 12,
    target: 20,
    unit: "días",
    status: "active",
  },
  {
    id: 3,
    title: "Meditar antes de dormir",
    progress: 100,
    current: 30,
    target: 30,
    unit: "días",
    status: "completed",
  },
  {
    id: 4,
    title: "Evitar cafeína después de 4pm",
    progress: 45,
    current: 9,
    target: 20,
    unit: "días",
    status: "active",
  },
];

const Objetivos = () => {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold tracking-tight">Objetivos</h1>
          <p className="text-muted-foreground">Establece y sigue tus metas de sueño</p>
        </div>
        <Button>
          <Target className="mr-2 h-4 w-4" />
          Nuevo Objetivo
        </Button>
      </div>

      <div className="grid gap-4 md:grid-cols-2">
        {goals.map((goal) => (
          <Card key={goal.id} className={goal.status === "completed" ? "border-primary" : ""}>
            <CardHeader>
              <div className="flex items-start justify-between">
                <div className="space-y-1">
                  <CardTitle className="text-base flex items-center gap-2">
                    {goal.status === "completed" ? (
                      <CheckCircle2 className="h-5 w-5 text-primary" />
                    ) : (
                      <Circle className="h-5 w-5 text-muted-foreground" />
                    )}
                    {goal.title}
                  </CardTitle>
                  <CardDescription>
                    {goal.current} de {goal.target} {goal.unit}
                  </CardDescription>
                </div>
                <div className="text-2xl font-bold">{goal.progress}%</div>
              </div>
            </CardHeader>
            <CardContent>
              <Progress value={goal.progress} className="h-2" />
              {goal.status === "completed" && (
                <p className="mt-2 text-sm font-medium text-primary">¡Objetivo completado! 🎉</p>
              )}
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
};

export default Objetivos;
