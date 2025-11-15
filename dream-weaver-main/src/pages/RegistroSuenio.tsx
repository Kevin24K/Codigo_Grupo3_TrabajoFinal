import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import { Slider } from "@/components/ui/slider";
import { Switch } from "@/components/ui/switch";
import { useState } from "react";
import { toast } from "sonner";

const RegistroSuenio = () => {
  const [quality, setQuality] = useState([7]);
  const [caffeine, setCaffeine] = useState(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    toast.success("Registro de sueño guardado exitosamente");
  };

  return (
    <div className="max-w-2xl mx-auto space-y-6">
      <div>
        <h1 className="text-3xl font-bold tracking-tight">Registro de Sueño</h1>
        <p className="text-muted-foreground">Registra tu experiencia de sueño de anoche</p>
      </div>

      <Card>
        <CardHeader>
          <CardTitle>Nuevo Registro</CardTitle>
          <CardDescription>Completa la información sobre tu sueño</CardDescription>
        </CardHeader>
        <CardContent>
          <form onSubmit={handleSubmit} className="space-y-6">
            <div className="grid gap-4 md:grid-cols-2">
              <div className="space-y-2">
                <Label htmlFor="bedtime">Hora de Dormir</Label>
                <Input id="bedtime" type="time" defaultValue="22:30" />
              </div>
              <div className="space-y-2">
                <Label htmlFor="wakeup">Hora de Despertar</Label>
                <Input id="wakeup" type="time" defaultValue="07:00" />
              </div>
            </div>

            <div className="space-y-2">
              <Label>Calidad del Sueño: {quality[0]}/10</Label>
              <Slider
                value={quality}
                onValueChange={setQuality}
                max={10}
                min={1}
                step={1}
                className="w-full"
              />
            </div>

            <div className="flex items-center justify-between">
              <div className="space-y-0.5">
                <Label htmlFor="caffeine">¿Consumiste cafeína?</Label>
                <p className="text-sm text-muted-foreground">En las últimas 6 horas antes de dormir</p>
              </div>
              <Switch id="caffeine" checked={caffeine} onCheckedChange={setCaffeine} />
            </div>

            <div className="space-y-2">
              <Label htmlFor="notes">Notas</Label>
              <Textarea 
                id="notes" 
                placeholder="¿Cómo te sentiste? ¿Algo que afectó tu sueño?"
                className="min-h-[100px]"
              />
            </div>

            <Button type="submit" className="w-full">
              Guardar Registro
            </Button>
          </form>
        </CardContent>
      </Card>
    </div>
  );
};

export default RegistroSuenio;
