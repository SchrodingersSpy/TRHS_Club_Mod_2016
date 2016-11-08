package epidemiccraft.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRabiesWolf extends ModelBase
{
  //fields
    ModelRenderer WolfHead;
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4Top;
    ModelRenderer Leg4Lower;
    ModelRenderer Tail;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;
  
  public ModelRabiesWolf()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      WolfHead = new ModelRenderer(this, 0, 0);
      WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
      WolfHead.setRotationPoint(-1F, 13.5F, -7F);
      WolfHead.setTextureSize(64, 32);
      WolfHead.mirror = true;
      setRotation(WolfHead, 0.2602503F, 0F, 0F);
      Body = new ModelRenderer(this, 16, 13);
      Body.addBox(-4F, -2F, -3F, 6, 9, 6);
      Body.setRotationPoint(0F, 14F, 1.7F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 1.645154F, 0F, 0F);
      Mane = new ModelRenderer(this, 20, 0);
      Mane.addBox(-4F, -3F, -3F, 8, 6, 7);
      Mane.setRotationPoint(-1F, 14F, -3F);
      Mane.setTextureSize(64, 32);
      Mane.mirror = true;
      setRotation(Mane, 1.533618F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 40, 13);
      Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg1.setRotationPoint(-2.5F, 16F, 7F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 50, 0);
      Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg2.setRotationPoint(0.5F, 16F, 7F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 50, 10);
      Leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
      Leg3.setRotationPoint(-2.5F, 16F, -4F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4Top = new ModelRenderer(this, 0, 17);
      Leg4Top.addBox(-1F, 0F, -1F, 2, 5, 2);
      Leg4Top.setRotationPoint(0.5F, 16F, -4F);
      Leg4Top.setTextureSize(64, 32);
      Leg4Top.mirror = true;
      setRotation(Leg4Top, -0.3346075F, 0F, 0F);
      Leg4Lower = new ModelRenderer(this, 0, 24);
      Leg4Lower.addBox(-1F, 0F, -1F, 2, 4, 2);
      Leg4Lower.setRotationPoint(0.5F, 19.7F, -5.9F);
      Leg4Lower.setTextureSize(64, 32);
      Leg4Lower.mirror = true;
      setRotation(Leg4Lower, 0.860927F, 0F, 0F);
      Tail = new ModelRenderer(this, 8, 17);
      Tail.addBox(-1F, 0F, -1F, 2, 8, 2);
      Tail.setRotationPoint(-1F, 12F, 8F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0.683926F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 14, 10);
      Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
      Ear1.setRotationPoint(-0.9F, 13.5F, -5F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, 0.5948578F, 0F, 0F);
      Ear2 = new ModelRenderer(this, 14, 10);
      Ear2.addBox(1F, -5F, 0F, 2, 2, 1);
      Ear2.setRotationPoint(-1.1F, 13.5F, -5F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, 0.5948578F, 0F, 0F);
      Nose = new ModelRenderer(this, 0, 10);
      Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
      Nose.setRotationPoint(-0.5F, 13.5F, -7F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0.2602503F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    WolfHead.render(f5);
    Body.render(f5);
    Mane.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4Top.render(f5);
    Leg4Lower.render(f5);
    Tail.render(f5);
    Ear1.render(f5);
    Ear2.render(f5);
    Nose.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}