import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Gift, Star, Lock } from "lucide-react";
import { Badge } from "@/components/ui/badge";

const rewards = [
  { id: 1, title: "Dormir 7 días seguidos", points: 100, unlocked: true, claimed: true },
  { id: 2, title: "Calidad perfecta 5 días", points: 150, unlocked: true, claimed: false },
  { id: 3, title: "30 días de seguimiento", points: 500, unlocked: false, progress: 23 },
  { id: 4, title: "Racha de 14 días", points: 300, unlocked: false, progress: 10 },
];

const achievements = [
  { id: 1, title: "Madrugador", description: "Despertaste antes de las 6am", icon: "🌅" },
  { id: 2, title: "Consistencia", description: "7 días seguidos registrando", icon: "📊" },
  { id: 3, title: "Experto en Sueño", description: "Promedio de 8h por 30 días", icon: "🏆" },
];

const Recompensas = () => {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Recompensas</h1>
        <p className="text-muted-foreground">Gana puntos y desbloquea logros</p>
      </div>

      <Card>
        <CardHeader>
          <CardTitle>Tus Puntos</CardTitle>
          <CardDescription>Acumula puntos completando objetivos</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="flex items-center gap-4">
            <div className="flex h-20 w-20 items-center justify-center rounded-full bg-primary/10">
              <Star className="h-10 w-10 text-primary" />
            </div>
            <div>
              <div className="text-4xl font-bold">850</div>
              <p className="text-muted-foreground">Puntos totales</p>
            </div>
          </div>
        </CardContent>
      </Card>

      <div>
        <h2 className="text-xl font-semibold mb-4">Recompensas Disponibles</h2>
        <div className="grid gap-4 md:grid-cols-2">
          {rewards.map((reward) => (
            <Card key={reward.id}>
              <CardContent className="flex items-center justify-between p-6">
                <div className="flex items-center gap-4">
                  <div
                    className={`flex h-12 w-12 items-center justify-center rounded-full ${
                      reward.unlocked ? "bg-primary/10" : "bg-muted"
                    }`}
                  >
                    {reward.unlocked ? (
                      <Gift className="h-6 w-6 text-primary" />
                    ) : (
                      <Lock className="h-6 w-6 text-muted-foreground" />
                    )}
                  </div>
                  <div>
                    <h3 className="font-semibold">{reward.title}</h3>
                    <p className="text-sm text-muted-foreground">
                      {reward.unlocked
                        ? `${reward.points} puntos`
                        : `${reward.progress}/30 días`}
                    </p>
                  </div>
                </div>
                {reward.unlocked && !reward.claimed && (
                  <Button size="sm">Reclamar</Button>
                )}
                {reward.claimed && (
                  <Badge variant="secondary">Reclamado</Badge>
                )}
              </CardContent>
            </Card>
          ))}
        </div>
      </div>

      <div>
        <h2 className="text-xl font-semibold mb-4">Logros Desbloqueados</h2>
        <div className="grid gap-4 md:grid-cols-3">
          {achievements.map((achievement) => (
            <Card key={achievement.id}>
              <CardHeader>
                <div className="text-4xl mb-2">{achievement.icon}</div>
                <CardTitle className="text-base">{achievement.title}</CardTitle>
                <CardDescription>{achievement.description}</CardDescription>
              </CardHeader>
            </Card>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Recompensas;
