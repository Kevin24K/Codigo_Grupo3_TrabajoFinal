import { StatCard } from "@/components/StatCard";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { TrendingUp, Clock, FileText, Coffee } from "lucide-react";
import { LineChart, Line, BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer } from "recharts";
import { useNavigate } from "react-router-dom";

// Datos de ejemplo
const sleepDurationData = [
  { day: "Lun", hours: 7.5 },
  { day: "Mar", hours: 6.8 },
  { day: "Mié", hours: 8.2 },
  { day: "Jue", hours: 7.0 },
  { day: "Vie", hours: 6.5 },
  { day: "Sáb", hours: 8.5 },
  { day: "Dom", hours: 9.0 },
];

const sleepQualityData = [
  { day: "Lun", quality: 7 },
  { day: "Mar", quality: 6 },
  { day: "Mié", quality: 8 },
  { day: "Jue", quality: 7 },
  { day: "Vie", quality: 5 },
  { day: "Sáb", quality: 9 },
  { day: "Dom", quality: 8 },
];

const Dashboard = () => {
  const navigate = useNavigate();

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold tracking-tight">Dashboard</h1>
          <p className="text-muted-foreground">Bienvenido, Usuario</p>
        </div>
        <Button onClick={() => navigate("/suenio")} className="bg-primary hover:bg-primary/90">
          Registrar Sueño
        </Button>
      </div>

      <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
        <StatCard
          title="Calidad Promedio"
          value="7.1/10"
          subtitle="Últimos 7 días"
          icon={TrendingUp}
        />
        <StatCard
          title="Duración Promedio"
          value="7.6h"
          subtitle="Por noche"
          icon={Clock}
        />
        <StatCard
          title="Registros"
          value="7"
          subtitle="Esta semana"
          icon={FileText}
        />
        <StatCard
          title="Cafeína"
          value="3"
          subtitle="Días con cafeína"
          icon={Coffee}
        />
      </div>

      <div className="grid gap-4 md:grid-cols-2">
        <Card>
          <CardHeader>
            <CardTitle>Duración del Sueño</CardTitle>
            <CardDescription>Horas dormidas por noche</CardDescription>
          </CardHeader>
          <CardContent>
            <ResponsiveContainer width="100%" height={300}>
              <BarChart data={sleepDurationData}>
                <CartesianGrid strokeDasharray="3 3" stroke="hsl(var(--border))" />
                <XAxis dataKey="day" stroke="hsl(var(--muted-foreground))" />
                <YAxis stroke="hsl(var(--muted-foreground))" />
                <Tooltip 
                  contentStyle={{ 
                    backgroundColor: "hsl(var(--card))",
                    border: "1px solid hsl(var(--border))",
                    borderRadius: "var(--radius)"
                  }}
                />
                <Bar dataKey="hours" fill="hsl(var(--primary))" radius={[8, 8, 0, 0]} />
              </BarChart>
            </ResponsiveContainer>
          </CardContent>
        </Card>

        <Card>
          <CardHeader>
            <CardTitle>Calidad del Sueño</CardTitle>
            <CardDescription>Puntuación de calidad (1-10)</CardDescription>
          </CardHeader>
          <CardContent>
            <ResponsiveContainer width="100%" height={300}>
              <LineChart data={sleepQualityData}>
                <CartesianGrid strokeDasharray="3 3" stroke="hsl(var(--border))" />
                <XAxis dataKey="day" stroke="hsl(var(--muted-foreground))" />
                <YAxis stroke="hsl(var(--muted-foreground))" domain={[0, 10]} />
                <Tooltip 
                  contentStyle={{ 
                    backgroundColor: "hsl(var(--card))",
                    border: "1px solid hsl(var(--border))",
                    borderRadius: "var(--radius)"
                  }}
                />
                <Line 
                  type="monotone" 
                  dataKey="quality" 
                  stroke="hsl(var(--primary))" 
                  strokeWidth={3}
                  dot={{ fill: "hsl(var(--primary))", r: 5 }}
                />
              </LineChart>
            </ResponsiveContainer>
          </CardContent>
        </Card>
      </div>
    </div>
  );
};

export default Dashboard;
